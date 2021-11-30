package com.economysa.motor.app.core.repository;

import com.economysa.motor.app.core.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, String> {

  @Query("select p from Product p where p.status = true order by p.name asc")
  Page<Product> findAll(Pageable pageable);

  @Query("select p from Product p where p.provider.id = :providerId and p.status = true")
  List<Product> findByProvider(@Param("providerId") Long providerId);

  @Query("select p from Product p where p.id = :id and p.status = true")
  Optional<Product> findById(@Param("id") Long id);

  @Query("select p from Product p where p.name like %:name% and p.status = true order by p.name asc")
  List<Product> find(@Param("name") String name);
}
