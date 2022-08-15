package com.economysa.motor.app.promotion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.economysa.motor.app.promotion.entity.MechanicBonus;

public interface MechanicBonusRepository extends CrudRepository<MechanicBonus, Long> {

    @Query("select mb from MechanicBonus mb join MechanicRules mr  on (mr.id = mb.mechanicRules.id)"+  
    		"where mr.mechanic.id = :mechanicId")
    List<MechanicBonus> findAll(@Param("mechanicId") Long mechanicId);
    

}