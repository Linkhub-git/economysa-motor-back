package com.economysa.motor.app.promotion.service;

import com.economysa.motor.app.promotion.controller.request.MechanicRulesRequest;
import com.economysa.motor.app.promotion.controller.response.MechanicRulesResponse;
import com.economysa.motor.app.promotion.entity.MechanicRules;

public interface MechanicRuleService {

	MechanicRulesResponse list(Long mechanicId);
    
    MechanicRulesResponse addRules(MechanicRulesRequest request);

    MechanicRules get(Long id);

    MechanicRules add(MechanicRules mechanicRules);

    void delete(Long id);

}
