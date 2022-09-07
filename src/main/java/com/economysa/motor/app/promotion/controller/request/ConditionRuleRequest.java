package com.economysa.motor.app.promotion.controller.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConditionRuleRequest {

    
    @NotNull
    private Long field_id;
    
    @NotNull
    private Long operator_id;

    @NotNull
    private String value;
    
}
