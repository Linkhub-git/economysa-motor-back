package com.economysa.motor.app.configuration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.economysa.motor.app.configuration.entity.QueryField;
import com.economysa.motor.app.configuration.repository.QueryFieldRepository;
import com.economysa.motor.app.configuration.service.QueryFieldService;

@Service
public class QueryFieldServiceImpl implements QueryFieldService {

  @Autowired private QueryFieldRepository repository;

  public List<QueryField> listFields() {
	    return (List<QueryField>) repository.findAll();
	  }

  public QueryField get(Long id) {
	  
	  return repository.findById(id).orElseThrow();
  }
  
}
