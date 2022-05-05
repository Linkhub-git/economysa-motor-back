package com.economysa.motor.app.configuration.repository;

import com.economysa.motor.app.configuration.entity.ListPrice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ListPriceRepository extends CrudRepository<ListPrice, Long> {

  @Query("select lp from ListPrice lp order by lp.code asc")
  List<ListPrice> findAll();

  @Query("select lp from ListPrice lp where lp.id = :id")
  Optional<ListPrice> findById(@Param("id") Long id);
}
