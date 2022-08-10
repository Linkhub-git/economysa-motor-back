package com.economysa.motor.app.promotion.repository;

import com.economysa.motor.app.promotion.entity.MechanicBonus;
import com.economysa.motor.app.promotion.entity.MechanicDiscount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface MechanicDiscountRepository extends CrudRepository<MechanicDiscount, Long> {

    @Query("select md from MechanicDiscount md where md.mechanicRules.id = :mechanicRulesId")
    List<MechanicDiscount> findAll(@Param("mechanicRulesId") Long mechanicRulesId);

    @Query("select md from MechanicDiscount md where md.mechanicRules.id = :mechanicRulesId" +
            " and md.percentageDiscount = :percentageDiscount")
    Optional<MechanicDiscount> findByMechanicAndDiscount(@Param("mechanicRulesId") Long mechanicRulesId,
                                                     @Param("percentageDiscount") BigDecimal percentageDiscount);
}
