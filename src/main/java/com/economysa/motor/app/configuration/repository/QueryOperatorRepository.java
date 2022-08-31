package com.economysa.motor.app.configuration.repository;

import org.springframework.data.repository.CrudRepository;

import com.economysa.motor.app.configuration.entity.QueryOperator;

public interface QueryOperatorRepository extends CrudRepository<QueryOperator, Long> {

  
}
