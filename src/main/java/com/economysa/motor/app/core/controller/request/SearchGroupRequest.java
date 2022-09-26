package com.economysa.motor.app.core.controller.request;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchGroupRequest {
	

	private Long groupId;

    private String groupOperator;
        
    private List<SearchConditionRequest> conditions;
   
    
    
}
