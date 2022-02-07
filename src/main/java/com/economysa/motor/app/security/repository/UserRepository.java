package com.economysa.motor.app.security.repository;

import com.economysa.motor.app.security.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @author QuickDev
 * @version 1.0
 */
public interface UserRepository extends CrudRepository<User, Long> {

	@Query("select u from User u where u.email = :email and u.status = true")
	Optional<User> findByEmail(@Param("email") String email);

	@Query("select u from User u where u.status = true order by u.name asc")
	Page<User> find(Pageable pageable);

	@Query("select u from User u where u.id = :id and u.status = true")
	Optional<User> findById(@Param("id") Long id);
}
