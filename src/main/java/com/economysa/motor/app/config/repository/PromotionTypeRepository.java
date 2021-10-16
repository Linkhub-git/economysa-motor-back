package com.economysa.motor.app.config.repository;

import com.economysa.motor.app.config.entity.PromotionType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PromotionTypeRepository extends CrudRepository<PromotionType, Long> {

  @Query("select pt from PromotionType pt")
  List<PromotionType> findAll();

  @Query("select pt from PromotionType pt where pt.id = :id")
  Optional<PromotionType> findById(@Param("id") Long id);
}
