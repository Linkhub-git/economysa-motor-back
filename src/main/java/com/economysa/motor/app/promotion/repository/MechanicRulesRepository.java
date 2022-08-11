package com.economysa.motor.app.promotion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.economysa.motor.app.promotion.entity.MechanicRules;

public interface MechanicRulesRepository extends CrudRepository<MechanicRules, Long> {

    @Query("select mr from MechanicRule mr where mr.mechanic.id = :mechanicId")
    List<MechanicRules> findAll(@Param("mechanicId") Long mechanicId);

}
