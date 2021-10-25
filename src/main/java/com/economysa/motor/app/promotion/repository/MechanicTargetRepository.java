package com.economysa.motor.app.promotion.repository;

import com.economysa.motor.app.promotion.entity.MechanicTarget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MechanicTargetRepository extends CrudRepository<MechanicTarget, Long> {

  @Query("select mt from MechanicTarget mt where mt.mechanic = :mechanicId")
  List<MechanicTarget> findByMechanic(@Param("mechanicId") Long mechanicId);

  @Query("select mt from MechanicTarget mt where mt.id = :id")
  Optional<MechanicTarget> findByTargetId(@Param("id") Long id);
}
