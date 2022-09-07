package com.economysa.motor.app.promotion.service;

import com.economysa.motor.app.promotion.controller.request.ConditionRulesRequest;
import com.economysa.motor.app.promotion.controller.response.ConditionRulesResponse;
import com.economysa.motor.app.promotion.entity.ConditionRules;

public interface ConditionRulesService {

  ConditionRulesResponse list(String type, Long mechanic_id);
  ConditionRulesResponse createConditions(String createUser, ConditionRulesRequest request);
  ConditionRulesResponse create(String createUser, ConditionRulesRequest request);
  ConditionRulesResponse delete(String updateUser, Long id);
  ConditionRules get(Long id);
}
