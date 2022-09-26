package com.economysa.motor.app.promotion.controller.response;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchRulesResponse {
	

	private Long searchId;

    private String searchOperator;
    
    private List<SearchGroupResponse> groups;	
}
