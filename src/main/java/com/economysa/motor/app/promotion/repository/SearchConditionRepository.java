package com.economysa.motor.app.promotion.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.economysa.motor.app.promotion.entity.SearchCondition;

public interface SearchConditionRepository extends CrudRepository<SearchCondition, String> {

	  @Query("select m from SearchCondition m where m.id = :id and status <> 'D' ")
	  Optional<SearchCondition> findById(@Param("id") Long id);
	  
	  @Query("select sc from SearchCondition sc join sc.searchGroup sg where sg.search.id= :searchId and status <> 'D' ")
	  List<SearchCondition> findBySearchId(@Param("searchId") Long searchId);
}
