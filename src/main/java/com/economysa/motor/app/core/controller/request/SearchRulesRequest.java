package com.economysa.motor.app.core.controller.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRulesRequest {

	private String searchOperator;
    private List<SearchGroupRequest> groups;
  
}
