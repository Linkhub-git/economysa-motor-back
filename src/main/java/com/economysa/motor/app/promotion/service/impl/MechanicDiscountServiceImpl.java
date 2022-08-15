package com.economysa.motor.app.promotion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.economysa.motor.app.promotion.controller.request.MechanicRuleRequest;
import com.economysa.motor.app.promotion.entity.MechanicDiscount;
import com.economysa.motor.app.promotion.repository.MechanicDiscountRepository;
import com.economysa.motor.app.promotion.service.MechanicDiscountService;
import com.economysa.motor.app.promotion.service.MechanicRuleService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class MechanicDiscountServiceImpl implements MechanicDiscountService {

	  @Autowired private MechanicDiscountRepository repository;
	  @Autowired private MechanicRuleService mechanicRuleService;

	  private MechanicDiscount init(MechanicRuleRequest mechanicRuleRequest,Long mechanicRuleId) {
		  
	    MechanicDiscount discount = new MechanicDiscount();
	    discount.setMechanicRules(mechanicRuleService.get(mechanicRuleId));
	    discount.setPercentageDiscount(mechanicRuleRequest.getPercentageDiscount());
	    
	    return discount;
	  }

	    public List<MechanicDiscount> findAll(Long mechanicId){

	    	return repository.findAll(mechanicId);
		
		}


	  @Override
	  public MechanicDiscount add(MechanicRuleRequest mechanicRuleRequest, Long mechanicRuleId) {	 
		MechanicDiscount discount = init(mechanicRuleRequest, mechanicRuleId);
	    return repository.save(discount);
	  }

	  @Override
	  public void delete(MechanicDiscount mechanicDiscount) {    
		  repository.deleteById(mechanicDiscount.getId());
	  }
}
