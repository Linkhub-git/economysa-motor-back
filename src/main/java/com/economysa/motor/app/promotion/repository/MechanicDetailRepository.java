package com.economysa.motor.app.promotion.repository;

import com.economysa.motor.app.promotion.entity.MechanicDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MechanicDetailRepository extends CrudRepository<MechanicDetail, Long> {

  @Query("select md from MechanicDetail md where md.mechanic.id = :mechanicId")
  List<MechanicDetail> findAll(@Param("mechanicId") Long mechanicId);
}
