package com.economysa.motor.app.promotion.controller.response;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.economysa.motor.app.promotion.controller.request.ConditionRuleRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConditionRulesResponse {
	
    @NotNull
    private Long mechanic;

    @NotNull
    private String type;
    
    @NotNull
    private List<ConditionRuleResponse> conditionRules;
    
}
