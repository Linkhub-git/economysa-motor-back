package com.economysa.motor.app.promotion.controller.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MechanicRuleResponse {
	
    private BigDecimal startRange;

    private BigDecimal endRange;

    private BigDecimal factor;

    private Long priority;
    
    private BigDecimal percentageDiscount;

    private Long productId;
    
    private BigDecimal bonusQuantity;

    private BigDecimal bonusMax;
    
}
