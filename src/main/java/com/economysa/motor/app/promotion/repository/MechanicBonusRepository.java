package com.economysa.motor.app.promotion.repository;

import com.economysa.motor.app.promotion.entity.MechanicBonus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MechanicBonusRepository extends CrudRepository<MechanicBonus, Long> {

  @Query("select mb from MechanicBonus mb where mb.mechanic = :mechanicId and mb.status = true")
  List<MechanicBonus> findByMechanic(@Param("mechanicId") Long mechanicId);

  @Query("select mb from MechanicBonus mb where mb.id = :id and mb.status = true")
  Optional<MechanicBonus> findById(@Param("id") Long id);
}
