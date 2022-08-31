package com.economysa.motor.app.configuration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.economysa.motor.app.configuration.entity.QueryCondition;
import com.economysa.motor.app.configuration.repository.QueryConditionRepository;
import com.economysa.motor.app.configuration.service.QueryConditionService;

@Service
public class QueryConditionServiceImpl implements QueryConditionService {

  @Autowired private QueryConditionRepository repository;

  public List<QueryCondition> listConditions() {
	    return (List<QueryCondition>) repository.findAll();
	  }
  
}
