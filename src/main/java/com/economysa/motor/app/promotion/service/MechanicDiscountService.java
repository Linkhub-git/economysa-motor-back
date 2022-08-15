package com.economysa.motor.app.promotion.service;

import java.util.List;

import com.economysa.motor.app.promotion.controller.request.MechanicRuleRequest;
import com.economysa.motor.app.promotion.entity.MechanicDiscount;

public interface MechanicDiscountService {
  
    List<MechanicDiscount> findAll(Long mechanicId);

	MechanicDiscount add(MechanicRuleRequest mechanicRuleRequest, Long mechanicRuleId);
  
	void delete(MechanicDiscount mechanicDiscount);

}
