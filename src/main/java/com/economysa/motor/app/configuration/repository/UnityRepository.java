package com.economysa.motor.app.configuration.repository;

import com.economysa.motor.app.configuration.entity.Unity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UnityRepository extends CrudRepository<Unity, Long> {

	@Query("select u from Unity u order by u.name asc")
	Page<Unity> findAll(Pageable pageable);

	@Query("select u from Unity u where u.id = :id")
	Optional<Unity> findById(@Param("id") Long id);

	@Query("select u from Unity u where u.code = :code")
	Unity findByCode(@Param("code") String code);
}
