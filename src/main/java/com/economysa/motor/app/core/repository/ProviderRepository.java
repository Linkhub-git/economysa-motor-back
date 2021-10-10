package com.economysa.motor.app.core.repository;

import com.economysa.motor.app.core.entity.Provider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProviderRepository extends CrudRepository<Provider, String> {

	@Query("select p from Provider p order by p.name asc")
	Page<Provider> findAll(Pageable pageable);

	@Query("select p from Provider p where p.id = :id and p.status = true")
	Optional<Provider> findById(@Param("id") String id);
}
