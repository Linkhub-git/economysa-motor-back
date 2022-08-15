package com.economysa.motor.app.promotion.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.economysa.motor.app.core.service.ProductService;
import com.economysa.motor.app.promotion.controller.request.MechanicRuleRequest;
import com.economysa.motor.app.promotion.entity.MechanicBonus;
import com.economysa.motor.app.promotion.repository.MechanicBonusRepository;
import com.economysa.motor.app.promotion.service.MechanicBonusService;
import com.economysa.motor.app.promotion.service.MechanicRuleService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class MechanicBonusServiceImpl implements MechanicBonusService {

  @Autowired private MechanicBonusRepository repository;
  @Autowired private MechanicRuleService mechanicRuleService;
  @Autowired private ProductService productService;

  private MechanicBonus init(MechanicRuleRequest mechanicRuleRequest,Long mechanicRuleId) {
	  
    MechanicBonus bonus = new MechanicBonus();
    bonus.setMechanicRules(mechanicRuleService.get(mechanicRuleId));
    bonus.setBonusMax(mechanicRuleRequest.getBonusMax());
    bonus.setBonusQuantity(mechanicRuleRequest.getBonusQuantity());
    bonus.setProduct(productService.get(mechanicRuleRequest.getProductId()));
    bonus.setQuantityUse(BigDecimal.ZERO);
    
    return bonus;
  }

  public List<MechanicBonus> findAll(Long mechanicId){
	return repository.findAll(mechanicId);  
  }

  @Override
  public MechanicBonus add(MechanicRuleRequest mechanicRuleRequest, Long mechanicRuleId) {	 
	MechanicBonus bonus = init(mechanicRuleRequest, mechanicRuleId);
    return repository.save(bonus);
  }

  @Override
  public void delete(MechanicBonus mechanicBonus) {    
	  repository.deleteById(mechanicBonus.getId());
  }
  
}
