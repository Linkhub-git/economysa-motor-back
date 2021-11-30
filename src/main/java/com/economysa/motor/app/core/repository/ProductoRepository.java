package com.economysa.motor.app.core.repository;

import com.economysa.motor.app.core.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductoRepository extends CrudRepository<Producto, String> {

	@Query("select p from Producto p order by p.id asc")
	Page<Producto> findAll(Pageable pageable);

	@Query("select p from Producto p where p.id = :id")
	Optional<Producto> findById(@Param("id") String id);
}
