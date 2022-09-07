package com.economysa.motor.app.promotion.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.economysa.motor.app.promotion.entity.ConditionRules;

public interface ConditionRulesRepository extends CrudRepository<ConditionRules, String> {

  @Query("select m from ConditionRules m where m.mechanic.id = :mechanic_id and m.type = :type and status <> 'D' order by m.creationDate asc")
  List<ConditionRules> findAll(@Param("type") String type, @Param("mechanic_id")Long mechanic_id);

  @Query("select m from ConditionRules m where m.id = :id and status <> 'D' ")
  Optional<ConditionRules> findById(@Param("id") Long id);
}
