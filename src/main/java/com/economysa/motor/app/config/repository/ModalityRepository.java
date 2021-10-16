package com.economysa.motor.app.config.repository;

import com.economysa.motor.app.config.entity.Modality;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ModalityRepository extends CrudRepository<Modality, Long> {

  @Query("select m from Modality m")
  List<Modality> findAll();

  @Query("select m from Modality m where m.id = :id")
  Optional<Modality> findById(@Param("id") Long id);
}
