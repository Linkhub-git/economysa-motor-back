package com.economysa.motor.app.core.repository;

import com.economysa.motor.app.core.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClienteRepository extends CrudRepository<Cliente, String> {

	@Query("select c from Cliente c order by c.codigo asc")
	Page<Cliente> findAll(Pageable pageable);

	@Query("select c from Cliente c where c.codigo = :codigo")
	Optional<Cliente> findByCodigo(@Param("codigo") String codigo);
}
