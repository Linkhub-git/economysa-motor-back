package com.economysa.motor.app.configuration.controller.response;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QueryCondFieldResponse {
	
    private ConditionResponse condition;
    private ArrayList<FieldResponse> fields;
    
    public QueryCondFieldResponse() {
    	
    	this.condition = new ConditionResponse();
    	this.fields = new ArrayList<FieldResponse>();
    }
	

	
}

