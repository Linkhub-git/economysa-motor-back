package com.economysa.motor.app.promotion.repository;

import com.economysa.motor.app.promotion.entity.MechanicDetailY;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MechanicDetailYRepository extends CrudRepository<MechanicDetailY, Long> {

  @Query("select md from MechanicDetailY md where md.mechanic.id = :mechanicId")
  List<MechanicDetailY> findAll(@Param("mechanicId") Long mechanicId);

  @Query("select md from MechanicDetailY md where md.mechanic.id = :mechanicId" +
         " and md.type = :type and md.code = :code")
  Optional<MechanicDetailY> findByMechanicAndTypeAndCode(@Param("mechanicId") Long mechanicId,
                                                         @Param("type") String type,
                                                         @Param("code") Long code);
}
