package com.economysa.motor.app.promotion.controller.response;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchGroupResponse {
	

	private Long groupId;

    private String groupOperator;
    
    private List<SearchConditionResponse> conditions;

	public SearchGroupResponse(Long groupId, String groupOperator, List<SearchConditionResponse> conditions) {
		super();
		this.groupId = groupId;
		this.groupOperator = groupOperator;
		this.conditions = conditions;
	}
    
    
    
}
