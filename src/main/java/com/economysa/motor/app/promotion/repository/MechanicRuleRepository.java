package com.economysa.motor.app.promotion.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.economysa.motor.app.promotion.entity.MechanicRule;

public interface MechanicRuleRepository extends CrudRepository<MechanicRule, Long> {

//    @Query("select mr from MechanicRule mr where mr.mechanic.id = :mechanicId")
//    List<MechanicRule> findAll(@Param("mechanicId") Long mechanicId);
//
//    @Query("select mr from MechanicRule mr where mr.mechanic.id = :mechanicId" +
//            " and mr.startRange = :startRange and mr.endRange = :endRange")
//    Optional<MechanicRule> findByMechanicAndStartRangeAndEndRange(@Param("mechanicId") Long mechanicId,
//                                                          @Param("startRange") Double startRange,
//                                                          @Param("endRange") Double endRange);
//
//    @Query("select mr from MechanicRule mr where mr.mechanic.id = :mechanicId" +
//            " and mr.factor = :factor")
//    Optional<MechanicRule> findByMechanicAndFactor(@Param("mechanicId") Long mechanicId,
//                                                                  @Param("factor") Double Factor);
//
//    @Query("select mr from MechanicRule mr where mr.mechanic.id = :mechanicId" +
//            " and mr.startRange = :startRange and mr.endRange = :endRange and mr.factor = :factor")
//    Optional<MechanicRule> findByMechanicAndStartRangeAndEndRangeAndFactor(@Param("mechanicId") Long mechanicId,
//                                                                  @Param("startRange") Double startRange,
//                                                                  @Param("endRange") Double endRange,
//                                                                  @Param("factor") Double factor);
}
