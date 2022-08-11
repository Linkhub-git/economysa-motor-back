package com.economysa.motor.app.promotion.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.economysa.motor.app.promotion.controller.request.MechanicRuleRequest;
import com.economysa.motor.app.promotion.controller.request.MechanicRulesRequest;
import com.economysa.motor.app.promotion.controller.response.MechanicRulesResponse;
import com.economysa.motor.app.promotion.entity.MechanicRules;
import com.economysa.motor.app.promotion.repository.MechanicRulesRepository;
import com.economysa.motor.app.promotion.service.MechanicRuleService;
import com.economysa.motor.app.promotion.service.MechanicService;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import com.economysa.motor.util.ConstantMessage;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class MechanicRuleServiceImpl implements MechanicRuleService {

    @Autowired private MechanicRulesRepository repository;

    @Autowired private MechanicService mechanicService;

    /**
     * Lista todos las reglas asociadas a una mecánica.
     * @param mechanicId - Identificador de la mecánica
     * @return - Listado de reglas asociadas a la mecánica.
     */
    @Override
    public MechanicRulesResponse list(Long mechanicId) {
    	
    	List<MechanicRules> list = repository.findAll(mechanicId);
    	
    	MechanicRulesResponse response = new MechanicRulesResponse();
    	response.setMechanic(mechanicId);
 
    	
    	for(MechanicRules obj:list) {
    		
    		
    	}
    	
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
    @Override
    public MechanicRulesResponse addRules(MechanicRulesRequest request) {

    	//LOGICA PENDIENTE POR DESARROLLAR
        for(MechanicRuleRequest req:request.getMechanicRules()){
            MechanicRules rule = init(request.getMechanic(), req);
            repository.save(rule);
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



   
}
