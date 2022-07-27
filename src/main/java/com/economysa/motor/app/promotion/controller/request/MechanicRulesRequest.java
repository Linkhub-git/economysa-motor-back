package com.economysa.motor.app.promotion.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MechanicRulesRequest {

    @NotNull
    private Long mechanic;

    @NotNull
    private List<MechanicRuleRequest> mechanicRules;
}
