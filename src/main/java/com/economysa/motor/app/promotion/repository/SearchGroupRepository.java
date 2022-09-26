package com.economysa.motor.app.promotion.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.economysa.motor.app.promotion.entity.SearchGroup;

public interface SearchGroupRepository extends CrudRepository<SearchGroup, String> {

	  @Query("select m from SearchGroup m where m.id = :id and status <> 'D' ")
	  Optional<SearchGroup> findById(@Param("id") Long id);
	  
	  @Query("select m.id from SearchGroup m where m.search.id = :searchId and status <> 'D' ")
	  List<SearchGroup> findBySearchId(@Param("searchId") Long searchId);
	  
}
