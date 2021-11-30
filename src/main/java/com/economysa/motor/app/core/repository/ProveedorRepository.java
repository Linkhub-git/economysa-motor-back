package com.economysa.motor.app.core.repository;

import com.economysa.motor.app.core.entity.Proveedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProveedorRepository extends CrudRepository<Proveedor, String> {

	@Query("select p from Proveedor p order by p.id asc")
	Page<Proveedor> findAll(Pageable pageable);

	@Query("select p from Proveedor p where p.id = :id")
	Optional<Proveedor> findById(@Param("id") String id);
}
