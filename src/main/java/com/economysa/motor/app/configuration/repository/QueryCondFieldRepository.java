package com.economysa.motor.app.configuration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.economysa.motor.app.configuration.entity.QueryCondField;
import com.economysa.motor.app.configuration.entity.QueryCondFieldId;

public interface QueryCondFieldRepository extends CrudRepository<QueryCondField, QueryCondFieldId> {

	@Query("select u from QueryCondField u where u.queryCondition.id = :conditionId")
	List<QueryCondField> findFields(@Param("conditionId") Long conditionId);

}
