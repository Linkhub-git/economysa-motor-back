package com.economysa.motor.app.promotion.service;

import java.util.List;

import com.economysa.motor.app.promotion.controller.request.MechanicRuleRequest;
import com.economysa.motor.app.promotion.entity.MechanicBonus;

public interface MechanicBonusService {
	  
  List<MechanicBonus> findAll(Long mechanicId);

  MechanicBonus add(MechanicRuleRequest mechanicRuleRequest,Long mechanicRuleId);
  
  void delete(MechanicBonus mechanicBonus);  

}
