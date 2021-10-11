package com.economysa.motor.app.core.repository;

import com.economysa.motor.app.core.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, String> {

  @Query("select p from Product p where p.status = true order by p.name asc")
  Page<Product> findAll(Pageable pageable);

  @Query("select p from Product p where p.id = :id and p.status = true")
  Optional<Product> findById(@Param("id") String id);
}
