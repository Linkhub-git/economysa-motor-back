package com.economysa.motor.app.promotion.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MechanicRuleRequest {

    @NotNull
    private Long mechanic;

    private Double startRange;

    private Double endRange;

    private Double factor;

    private Integer priority;
}
