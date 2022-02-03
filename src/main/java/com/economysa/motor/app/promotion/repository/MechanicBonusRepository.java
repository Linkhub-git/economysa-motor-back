package com.economysa.motor.app.promotion.repository;

import com.economysa.motor.app.promotion.entity.MechanicBonus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MechanicBonusRepository extends CrudRepository<MechanicBonus, Long> {

  @Query("select mb from MechanicBonus mb where mb.mechanic.id = :mechanicId order by mb.priority asc")
  List<MechanicBonus> findAll(@Param("mechanicId") Long mechanicId);

  @Query("select mb from MechanicBonus mb where mb.mechanic.id = :mechanicId" +
         " and mb.product.id = :product")
  Optional<MechanicBonus> findByMechanicAndProduct(@Param("mechanicId") Long mechanicId,
                                                   @Param("product") Long product);
}
