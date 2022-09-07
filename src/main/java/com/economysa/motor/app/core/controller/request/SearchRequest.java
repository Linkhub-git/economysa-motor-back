package com.economysa.motor.app.core.controller.request;

import java.util.List;

import com.economysa.motor.app.promotion.controller.request.ConditionRuleRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {


    private List<ConditionRuleRequest> conditionRules;

  
}
