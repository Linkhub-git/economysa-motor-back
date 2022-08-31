package com.economysa.motor.app.configuration.repository;

import org.springframework.data.repository.CrudRepository;

import com.economysa.motor.app.configuration.entity.QueryCondition;

public interface QueryConditionRepository extends CrudRepository<QueryCondition, Long> {

  
}
