package com.economysa.motor.app.promotion.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MechanicRulesResponse {

    @NotNull
    private Long mechanic;

    @NotNull
    private List<MechanicRuleResponse> mechanicRules;
}
