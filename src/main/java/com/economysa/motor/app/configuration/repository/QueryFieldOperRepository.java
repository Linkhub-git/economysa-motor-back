package com.economysa.motor.app.configuration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.economysa.motor.app.configuration.entity.QueryCondField;
import com.economysa.motor.app.configuration.entity.QueryFieldOper;
import com.economysa.motor.app.configuration.entity.QueryFieldOperId;

public interface QueryFieldOperRepository extends CrudRepository<QueryFieldOper, QueryFieldOperId> {

	@Query("select u from QueryFieldOper u where u.queryField.id = :fieldId")
	List<QueryFieldOper> findOperators(@Param("fieldId") Long fieldId);
}
