package com.economysa.motor.app.promotion.service;

import java.util.Map;

import com.economysa.motor.app.core.controller.request.SearchGroupRequest;
import com.economysa.motor.app.promotion.controller.response.SearchResponse;
import com.economysa.motor.app.promotion.entity.SearchGroup;

public interface SearchGroupService {

	  SearchGroup create(String creationUser, SearchGroupRequest request, Long searchId);
	  SearchGroup update(String updateUser, SearchGroupRequest request);
	  SearchResponse delete(String updateUser, Long id);
	  SearchGroup get(Long id);
	  Map<Long,Long> findBySearchId(Long searchId);
}
