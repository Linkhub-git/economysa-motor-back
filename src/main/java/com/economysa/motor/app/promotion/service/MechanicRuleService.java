package com.economysa.motor.app.promotion.service;

import com.economysa.motor.app.promotion.controller.request.MechanicRuleRequest;
import com.economysa.motor.app.promotion.entity.MechanicRule;

import java.util.List;

public interface MechanicRuleService {

    List<MechanicRule> list(Long mechanicId);

    MechanicRule add(MechanicRuleRequest request);
}
