package com.economysa.motor.app.core.repository;

import com.economysa.motor.app.core.entity.Promocion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PromocionRepository extends CrudRepository<Promocion, String> {

	@Query("select p from Promocion p order by p.idMecanica asc")
	Page<Promocion> findAll(Pageable pageable);

	@Query("select p from Promocion p where p.idMecanica = :id")
	Optional<Promocion> findById(@Param("id") String id);
}
