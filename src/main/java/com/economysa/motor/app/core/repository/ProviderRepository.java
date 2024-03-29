package com.economysa.motor.app.core.repository;

import com.economysa.motor.app.core.entity.Provider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProviderRepository extends CrudRepository<Provider, String> {

	@Query("select p from Provider p where p.status = true order by p.name asc")
	Page<Provider> findAll(Pageable pageable);

	@Query("select p from Provider p where p.id = :id and p.status = true")
	Optional<Provider> findById(@Param("id") Long id);

	@Query("select p from Provider p where p.name like %:name% and p.status = true order by p.name asc")
	List<Provider> find(@Param("name") String name);
}
