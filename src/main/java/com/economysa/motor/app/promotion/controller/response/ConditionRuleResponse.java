package com.economysa.motor.app.promotion.controller.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ConditionRuleResponse {
	

	public ConditionRuleResponse(Long id, Long field_id, Long operator_id, String value) {
		super();
		this.id = id;
		this.field_id = field_id;
		this.operator_id = operator_id;
		this.value = value;
	}

	private Long id;
    
    private Long field_id;
    
    private Long operator_id;

    private String value;
    
    
}
