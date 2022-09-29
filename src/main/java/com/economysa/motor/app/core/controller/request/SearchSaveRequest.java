package com.economysa.motor.app.core.controller.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchSaveRequest {
	
    @NotNull
    private Long mechanic;

    @NotNull
    private String type;
    
    @NotNull
    private SearchRulesRequest searchRules;
    
}
