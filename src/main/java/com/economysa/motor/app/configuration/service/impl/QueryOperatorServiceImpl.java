package com.economysa.motor.app.configuration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.economysa.motor.app.configuration.entity.QueryOperator;
import com.economysa.motor.app.configuration.repository.QueryOperatorRepository;
import com.economysa.motor.app.configuration.service.QueryOperatorService;

@Service
public class QueryOperatorServiceImpl implements QueryOperatorService {

  @Autowired private QueryOperatorRepository repository;

  public List<QueryOperator> listOperators() {
    return (List<QueryOperator>) repository.findAll();
  }


  public QueryOperator get(Long id) {
	  
	  return repository.findById(id).orElseThrow();
  }
  
}
