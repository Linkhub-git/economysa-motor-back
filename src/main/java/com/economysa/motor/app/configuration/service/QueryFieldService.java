package com.economysa.motor.app.configuration.service;

import java.util.List;

import com.economysa.motor.app.configuration.entity.QueryField;

public interface QueryFieldService {

  List<QueryField> listFields();
  
  QueryField get(Long id);
 
}
