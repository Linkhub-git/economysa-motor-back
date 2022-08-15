package com.economysa.motor.app.promotion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.economysa.motor.app.promotion.entity.MechanicDiscount;

public interface MechanicDiscountRepository extends CrudRepository<MechanicDiscount, Long> {

    @Query("select md from MechanicDiscount md join MechanicRules mr  on (mr.id = md.mechanicRules.id)"+  
    		"where mr.mechanic.id = :mechanicId")
    List<MechanicDiscount> findAll(@Param("mechanicId") Long mechanicId);
    
}