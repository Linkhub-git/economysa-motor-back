package com.economysa.motor.app.promotion.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.economysa.motor.app.core.service.ProductService;
import com.economysa.motor.app.promotion.controller.request.MechanicRuleRequest;
import com.economysa.motor.app.promotion.controller.request.MechanicRulesRequest;
import com.economysa.motor.app.promotion.controller.response.MechanicRuleResponse;
import com.economysa.motor.app.promotion.controller.response.MechanicRulesResponse;
import com.economysa.motor.app.promotion.entity.Mechanic;
import com.economysa.motor.app.promotion.entity.MechanicBonus;
import com.economysa.motor.app.promotion.entity.MechanicDiscount;
import com.economysa.motor.app.promotion.entity.MechanicRules;
import com.economysa.motor.app.promotion.repository.MechanicRulesRepository;
import com.economysa.motor.app.promotion.service.MechanicBonusService;
import com.economysa.motor.app.promotion.service.MechanicDiscountService;
import com.economysa.motor.app.promotion.service.MechanicRuleService;
import com.economysa.motor.app.promotion.service.MechanicService;
import com.economysa.motor.error.exception.BadRequestException;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import com.economysa.motor.util.ConstantMessage;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class MechanicRuleServiceImpl implements MechanicRuleService {

    @Autowired private MechanicRulesRepository repository;

    @Autowired private ProductService productService;
    @Autowired private MechanicService mechanicService;
    @Autowired private MechanicBonusService mechanicBonusService;
    @Autowired private MechanicDiscountService mechanicDiscountService;

    /**
     * Lista todos las reglas asociadas a una mecánica.
     * @param mechanicId - Identificador de la mecánica
     * @return - Listado de reglas asociadas a la mecánica.
     */
    @Override
    public MechanicRulesResponse list(Long mechanicId) {
    	
    	List<MechanicRuleResponse> list = new ArrayList<MechanicRuleResponse>();
    	MechanicRuleResponse resp = null;

    	Mechanic mec = mechanicService.get(mechanicId);
    	
    	if(mec.getPromotionType().equals(ConstantMessage.MECHANIC_PROMOTION_TYPE_PRODUCT)) {
    		
        	List<MechanicBonus> listBonus = mechanicBonusService.findAll(mechanicId);
        	
        	for(MechanicBonus obj:listBonus) {
        		
        		resp = new MechanicRuleResponse(obj.getMechanicRules().getStartRange(),
        										obj.getMechanicRules().getEndRange(),
        										obj.getMechanicRules().getFactor(),
        										obj.getMechanicRules().getPriority(), 
        										null, 
        										obj.getProduct().getId(), 
        										obj.getBonusQuantity(),
        										obj.getBonusMax());
        		list.add(resp);        		
        	}
        	
    	}else {
    	
        	List<MechanicDiscount> listDiscount = mechanicDiscountService.findAll(mechanicId);
        	
        	for(MechanicDiscount obj:listDiscount) {
        		
        		resp = new MechanicRuleResponse(obj.getMechanicRules().getStartRange(),
						obj.getMechanicRules().getEndRange(),
						obj.getMechanicRules().getFactor(),
						obj.getMechanicRules().getPriority(), 
						obj.getPercentageDiscount(), 
						null, 
						null,
						null);
        		
        		list.add(resp);        		

        	}
    	}
    	
    	MechanicRulesResponse response = new MechanicRulesResponse();
    	response.setMechanicRules(list);
    	response.setMechanic(mechanicId);
 
        return response;
    }

    /**
     * Recupera regla por Id
     * @param id - id de la mechanicRule
     * @return - Retorna la mechanicRule
     */
    @Override
    public MechanicRules get(Long id) {
      Optional<MechanicRules> mechanic = repository.findById(id);
      if (!mechanic.isPresent()) {
        log.info("No Mechanic entity for ID [ " + id + " ]");
        throw new ResourceNotFoundException(ConstantMessage.MECHANIC_NOT_FOUND);
      }
      return mechanic.get();
    }
    

    /**
     * Agrega una regla
     * @param mechanicRules - Entidad a registrar
     * @return - Retorna item registrado.
     */
    @Override
    public MechanicRules add(MechanicRules mechanicRules) {
        return repository.save(mechanicRules);
    }
    
    /**
     * elimina una regla.
     * @param id - id de regla
     */
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
    /**
     * Agrega un listado nuevo de items ( no repetido ) a las reglas
     * de la mecánica.
     * @param request - Items a registrar
     * @return - Retorna los item ya registrados.
     */
	
    public MechanicRulesResponse addRules(MechanicRulesRequest request) {

    	Mechanic mec = mechanicService.get(request.getMechanic());
    	
    	validateRequest(mec,request);
    	
    	if(mec.getPromotionType().equals(ConstantMessage.MECHANIC_PROMOTION_TYPE_PRODUCT)) {

        	List<MechanicBonus> listBonus = mechanicBonusService.findAll(request.getMechanic());

        	for(MechanicBonus obj:listBonus){
                
        		mechanicBonusService.delete(obj);
        		repository.delete(obj.getMechanicRules());
        		
            }
            
            for(MechanicRuleRequest req:request.getMechanicRules()){
                MechanicRules rule = init(request.getMechanic(), req);
                rule =  repository.save(rule);
                mechanicBonusService.add(req, rule.getId());
            }
    		
    	}else {
    		
        	List<MechanicDiscount> listDiscount = mechanicDiscountService.findAll(request.getMechanic());

            for(MechanicDiscount obj:listDiscount){
                
            	mechanicDiscountService.delete(obj);
        		repository.delete(obj.getMechanicRules());
        		
            }
            
            for(MechanicRuleRequest req:request.getMechanicRules()){
                MechanicRules rule = init(request.getMechanic(), req);
                rule =  repository.save(rule);
                mechanicDiscountService.add(req, rule.getId());
               }
    		
    	}
    	
 

        
        return list(request.getMechanic());
        
    }
	
    /**
     * Inicializa un objeto MechanicDetail.
     * @param request - Item a registrar
     * @return - Retorna el objeto inicializado.
     */
    private MechanicRules init(Long mechanicId, MechanicRuleRequest request) {

        MechanicRules rule = new MechanicRules();
        rule.setMechanic(mechanicService.get(mechanicId));
        rule.setStartRange(request.getStartRange());
        rule.setEndRange(request.getEndRange());
        rule.setFactor(request.getFactor());
        rule.setPriority(request.getPriority());
        return rule;
    }


    /**
     * Verifica si tienes los campos mandatorios y si los rangos no se repiten
     * @param request - Item a registrar
     * @throws BadRequestException - Lanza excepción si el
     * item no cuenta con todos los campos o si los rangos se repiten.
     */
    private void validateRequest(Mechanic mec, MechanicRulesRequest request) {
    	
    
	    if(mec.getPromotionType().equals(ConstantMessage.MECHANIC_PROMOTION_TYPE_PRODUCT)) {
	    	

	    	List<String> duplicateList = request.getMechanicRules()
					    	            .stream()
					    	            .collect(Collectors.groupingBy(s -> s.getStartRange()+"-"+s.getEndRange()))
					    	            .entrySet()
					    	            .stream()
					    	            .filter(e -> e.getValue().size() > 1)
					    	            .map(e -> e.getKey())
					    	            .collect(Collectors.toList());
	    	
	    	if(duplicateList.size()>0) {
	    		
	    		log.info(ConstantMessage.ERROR_INPUT_VALIDATION_FAILED +" Range Repeat");
		        throw new BadRequestException(ConstantMessage.ERROR_INPUT_VALIDATION_FAILED +" Range Repeat");
	    	}
	    	
	    	for(MechanicRuleRequest obj: request.getMechanicRules()) {
	    		
	    		if(obj.getBonusMax()==null) {
	    			
	    			log.info(ConstantMessage.ERROR_INPUT_VALIDATION_FAILED +" BonusMax");
	    	        throw new BadRequestException(ConstantMessage.ERROR_INPUT_VALIDATION_FAILED +" BonusMax");
	    		}
	    		
				if(obj.getBonusQuantity()==null) {
					    			
					log.info(ConstantMessage.ERROR_INPUT_VALIDATION_FAILED +" BonusQuantity");
			        throw new BadRequestException(ConstantMessage.ERROR_INPUT_VALIDATION_FAILED +" BonusQuantity");
				}
				
				if(obj.getProductId()==null) {
					
					log.info(ConstantMessage.ERROR_INPUT_VALIDATION_FAILED +" ProductId");
			        throw new BadRequestException(ConstantMessage.ITEM_ALREADY_ADDED +" ProductId");					
					
				}else {
					
					productService.get(obj.getProductId());
					
				}
				
	    	}
	    	
	    }
	    
	    if(mec.getPromotionType().equals(ConstantMessage.MECHANIC_PROMOTION_TYPE_DISCOUNT)) {
	    	
	    	List<String> duplicateList = request.getMechanicRules()
    	            .stream()
    	            .collect(Collectors.groupingBy(s -> s.getStartRange()+"-"+s.getEndRange()))
    	            .entrySet()
    	            .stream()
    	            .filter(e -> e.getValue().size() > 1)
    	            .map(e -> e.getKey())
    	            .collect(Collectors.toList());

			if(duplicateList.size()>0) {
			
			log.info(ConstantMessage.ERROR_INPUT_VALIDATION_FAILED +" Range Repeat");
			throw new BadRequestException(ConstantMessage.ERROR_INPUT_VALIDATION_FAILED +" Range Repeat");
			}

	    	for(MechanicRuleRequest obj: request.getMechanicRules()) {

	    		if(obj.getPercentageDiscount()==null) {
	    			
	    			log.info(ConstantMessage.ERROR_INPUT_VALIDATION_FAILED +" percentageDiscount");
	    	        throw new BadRequestException(ConstantMessage.ERROR_INPUT_VALIDATION_FAILED +" percentageDiscount");
	    		}

	    	}
	    	
	    }
	    
    }   	
      

   
}
