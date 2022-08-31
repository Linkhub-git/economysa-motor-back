package com.economysa.motor.app.configuration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.economysa.motor.app.configuration.controller.response.OperatorResponse;
import com.economysa.motor.app.configuration.controller.response.QueryFieldOperResponse;
import com.economysa.motor.app.configuration.entity.QueryFieldOper;
import com.economysa.motor.app.configuration.repository.QueryFieldOperRepository;
import com.economysa.motor.app.configuration.service.QueryFieldOperService;

@Service
public class QueryFieldOperServiceImpl implements QueryFieldOperService{

  @Autowired private QueryFieldOperRepository repository;

  public QueryFieldOperResponse listOperatorByField(Long fieldId){
	  
	  QueryFieldOperResponse response = new QueryFieldOperResponse();
	  
	  List<QueryFieldOper> list = repository.findOperators(fieldId);
	  
	  for(QueryFieldOper obj: list) {
		  
		  response.getField().setId(obj.getQueryField().getId());
		  response.getField().setName(obj.getQueryField().getName());
		  response.getOperators().add(new OperatorResponse(obj.getQueryOperator().getId(), obj.getQueryOperator().getName()));
		  
	  }
	  
	  return response;
	  
	  }
}
