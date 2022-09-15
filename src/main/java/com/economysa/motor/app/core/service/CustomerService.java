package com.economysa.motor.app.core.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.economysa.motor.app.core.controller.dto.CustomerDto;
import com.economysa.motor.app.core.controller.request.SearchRequest;
import com.economysa.motor.app.core.entity.Customer;

public interface CustomerService {

  Customer init(CustomerDto dto);
  void saveAll(List<Customer> items);

  Page<Customer> list(Pageable pageable);
  List<Customer> findByConditions(SearchRequest req);
  
  Customer get(Long id);
  Customer getByCustomerCode(String id);

}
