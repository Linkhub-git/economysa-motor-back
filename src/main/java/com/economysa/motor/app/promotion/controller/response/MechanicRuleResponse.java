package com.economysa.motor.app.promotion.controller.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MechanicRuleResponse {

    private Double startRange;

    private Double endRange;

    private Double factor;

    private Integer priority;
    
    private BigDecimal percentageDiscount;

    private Long productId;
    
    private BigDecimal bonusQuantity;

    private BigDecimal bonusMax;
    
}
