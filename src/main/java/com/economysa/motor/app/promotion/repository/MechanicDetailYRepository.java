package com.economysa.motor.app.promotion.repository;

import com.economysa.motor.app.promotion.entity.MechanicDetailY;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MechanicDetailYRepository extends CrudRepository<MechanicDetailY, Long> {

  @Query("select md from MechanicDetailY md where md.mechanic.id = :mechanicId")
  List<MechanicDetailY> findAll(@Param("mechanicId") Long mechanicId);
}
