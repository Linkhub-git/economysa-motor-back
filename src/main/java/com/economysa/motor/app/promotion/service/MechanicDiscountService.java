package com.economysa.motor.app.promotion.service;

import com.economysa.motor.app.promotion.controller.request.MechanicRuleRequest;
import com.economysa.motor.app.promotion.entity.MechanicDiscount;

public interface MechanicDiscountService {
  
	MechanicDiscount add(MechanicRuleRequest mechanicRuleRequest, Long mechanicRuleId);
  
  void delete(MechanicDiscount mechanicDiscount);

}
