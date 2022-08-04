package com.economysa.motor.app.promotion.repository;

import com.economysa.motor.app.promotion.entity.MechanicBonus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MechanicBonusRepository extends CrudRepository<MechanicBonus, Long> {

  @Query("select mb from MechanicBonus mb where mb.mechanicRules.id = :mechanicRulesId")
  List<MechanicBonus> findAll(@Param("mechanicRulesId") Long mechanicRulesId);

  @Query("select mb from MechanicBonus mb where mb.mechanicRules.id = :mechanicRulesId" +
         " and mb.product.id = :product")
  Optional<MechanicBonus> findByMechanicAndProduct(@Param("mechanicRulesId") Long mechanicRulesId,
                                                   @Param("product") Long product);
}
