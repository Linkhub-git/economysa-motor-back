package com.economysa.motor.app.core.controller.request;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchRulesRequest {
	

	private Long searchId;

    private String searchOperator;
    
    private List<SearchGroupRequest> groups;	
}
