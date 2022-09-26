package com.economysa.motor.app.promotion.service;

import java.util.Map;

import com.economysa.motor.app.core.controller.request.SearchConditionRequest;
import com.economysa.motor.app.promotion.controller.response.SearchResponse;
import com.economysa.motor.app.promotion.entity.SearchCondition;

public interface SearchConditionService {

	
	  SearchCondition create(String creationUser, SearchConditionRequest request, Long groupId);
	  SearchCondition update(String updateUser, SearchConditionRequest searchCondition);
	  SearchResponse delete(String updateUser, Long id);
	  SearchCondition get(Long id);
	  Map<Long,Long> findBySearchId(Long searchId);

}
