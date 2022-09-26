package com.economysa.motor.app.promotion.controller.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchConditionResponse {
	

	private Long conditionId;
    
    private Long fieldId;
    
    private Long operatorId;

    private String value;

	public SearchConditionResponse(Long conditionId, Long fieldId, Long operatorId, String value) {
		super();
		this.conditionId = conditionId;
		this.fieldId = fieldId;
		this.operatorId = operatorId;
		this.value = value;
	}
    
    
}
