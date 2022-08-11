package com.economysa.motor.app.promotion.service;

import com.economysa.motor.app.promotion.controller.request.MechanicRuleRequest;
import com.economysa.motor.app.promotion.entity.MechanicBonus;

public interface MechanicBonusService {
	  
  MechanicBonus add(MechanicRuleRequest mechanicRuleRequest,Long mechanicRuleId);
  
  void delete(MechanicBonus mechanicBonus);  

}
