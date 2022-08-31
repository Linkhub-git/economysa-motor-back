package com.economysa.motor.app.configuration.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class QueryFieldOperResponse {

    private FieldResponse field;
    private ArrayList<OperatorResponse> operators;
    
	public QueryFieldOperResponse() {
	this.field = new FieldResponse();
	this.operators = new ArrayList<OperatorResponse>();
	}

}
