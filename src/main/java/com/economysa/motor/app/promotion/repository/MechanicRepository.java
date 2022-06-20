package com.economysa.motor.app.promotion.repository;

import com.economysa.motor.app.promotion.entity.Mechanic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MechanicRepository extends CrudRepository<Mechanic, String> {

  @Query("select m from Mechanic m order by m.creationDate desc")
  Page<Mechanic> findAll(Pageable pageable);

  @Query("select m from Mechanic m where m.startDate => :currentDate and m.endDate <= :currentDate and m.status = 'C'")
  List<Mechanic> findActive(@Param("currentDate") Date currentDate);

  @Query("select m from Mechanic m where m.emitter = :emitter order by m.creationDate desc")
  Page<Mechanic> find(@Param("emitter") String emitter, Pageable pageable);

  @Query("select m from Mechanic m where m.id = :id")
  Optional<Mechanic> findById(@Param("id") Long id);
}
