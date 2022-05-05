package com.economysa.motor.app.promotion.repository;

import com.economysa.motor.app.promotion.entity.MechanicEntry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MechanicEntryRepository extends CrudRepository<MechanicEntry, Long> {

  @Query("select me from MechanicEntry me where me.mechanic = :idMechanic")
  List<MechanicEntry> findByMechanic(@Param("idMechanic") Long idMechanic);

  @Query("select me from MechanicEntry me where me.mechanic = :idMechanic and me.type = :type " +
        "and me.identifier = :identifier")
  Optional<MechanicEntry> findByMechanicAndTypeAndIdentifier(
        @Param("idMechanic") Long idMechanic,
        @Param("type") String type,
        @Param("identifier") Long identifier);
}
