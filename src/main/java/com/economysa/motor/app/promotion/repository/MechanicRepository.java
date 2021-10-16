package com.economysa.motor.app.promotion.repository;

import com.economysa.motor.app.promotion.entity.Mechanic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MechanicRepository extends CrudRepository<Mechanic, String> {

  @Query("select m from Mechanic m where m.status = true order by m.creationDate desc")
  Page<Mechanic> findAll(Pageable pageable);

  @Query("select m from Mechanic m where m.id = :id and m.status = true")
  Optional<Mechanic> findById(@Param("id") Long id);
}
