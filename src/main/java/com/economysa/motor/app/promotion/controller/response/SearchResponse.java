package com.economysa.motor.app.promotion.controller.response;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResponse {
	
	
    @NotNull
    private Long mechanic;

    @NotNull
    private String type;
    
    @NotNull
    private SearchRulesResponse searchRules;
    
}
