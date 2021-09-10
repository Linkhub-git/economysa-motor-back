package com.economysa.motor.app.core.repository;

import com.economysa.motor.app.core.entity.DireccionEntrega;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DireccionEntregaRepository extends CrudRepository<DireccionEntrega, String> {

	@Query("select de from DireccionEntrega de order by de.codDireccion asc")
	Page<DireccionEntrega> findAll(Pageable pageable);

	@Query("select de from DireccionEntrega de where de.codDireccion = :codigo")
	Optional<DireccionEntrega> findByCodigo(@Param("codigo") String codigo);
}
