package com.economysa.motor.app.configuration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.economysa.motor.app.configuration.controller.response.FieldResponse;
import com.economysa.motor.app.configuration.controller.response.QueryCondFieldResponse;
import com.economysa.motor.app.configuration.entity.QueryCondField;
import com.economysa.motor.app.configuration.repository.QueryCondFieldRepository;
import com.economysa.motor.app.configuration.service.QueryCondFieldService;

@Service
public class QueryCondFieldServiceImpl implements QueryCondFieldService{

	@Autowired private QueryCondFieldRepository repository;

	public QueryCondFieldResponse listFieldByCondition(Long conditionId){

		QueryCondFieldResponse response = new QueryCondFieldResponse();
		  
		  List<QueryCondField> list = repository.findFields(conditionId);
		  
		  for(QueryCondField obj: list) {
			  
			  response.getCondition().setId(obj.getQueryCondition().getId());
			  response.getCondition().setName(obj.getQueryCondition().getName());
			  response.getFields().add(new FieldResponse(obj.getQueryField().getId(), obj.getQueryField().getName()));
			  
		  }
		  
		  return response;
		  
	}
}
