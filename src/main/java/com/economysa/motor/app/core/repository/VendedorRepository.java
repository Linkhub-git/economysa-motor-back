package com.economysa.motor.app.core.repository;

import com.economysa.motor.app.core.entity.Vendedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VendedorRepository extends CrudRepository<Vendedor, String> {

	@Query("select v from Vendedor v order by v.codigo asc")
	Page<Vendedor> findAll(Pageable pageable);

	@Query("select v from Vendedor v where v.codigo = :codigo")
	Optional<Vendedor> findByCodigo(@Param("codigo") String codigo);
}
