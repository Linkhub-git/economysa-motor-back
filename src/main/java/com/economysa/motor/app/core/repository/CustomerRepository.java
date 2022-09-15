package com.economysa.motor.app.core.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.economysa.motor.app.core.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String>, JpaSpecificationExecutor<Customer>  {

@Query("select p from Customer p order by p.code asc")
Page<Customer> findAll(Pageable pageable);

@Query("select p from Customer p where p.id = :id")
Optional<Customer> getByCustomerId(@Param("id") Long id);
  
@Query("select p from Customer p where p.code = :code")
Optional<Customer> getByCustomerCode(@Param("code") String code);
 

}