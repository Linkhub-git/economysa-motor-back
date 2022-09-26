package com.economysa.motor.app.promotion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.economysa.motor.app.promotion.entity.Search;

public interface SearchRepository extends CrudRepository<Search, String> {

  @Query("select m from Search m where m.mechanic.id = :mechanic_id and m.type = :type and status <> 'D' order by m.creationDate asc")
  Optional<Search> findAll(@Param("type") String type, @Param("mechanic_id")Long mechanic_id);

  @Query("select m from Search m where m.id = :id and status <> 'D' ")
  Optional<Search> findById(@Param("id") Long id);
}
