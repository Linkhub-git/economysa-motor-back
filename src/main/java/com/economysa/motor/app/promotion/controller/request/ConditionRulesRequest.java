package com.economysa.motor.app.promotion.controller.request;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConditionRulesRequest {


    @NotNull
    private Long mechanic;

    @NotNull
    private String type;
    
    private ConditionRuleRequest conditionRule;

    private List<ConditionRuleRequest> conditionRules;
    
}
