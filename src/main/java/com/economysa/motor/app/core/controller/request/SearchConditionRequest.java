package com.economysa.motor.app.core.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchConditionRequest {
	

	private Long conditionId;
    
    private Long fieldId;
    
    private Long operatorId;

    private String value;
        
    
}
