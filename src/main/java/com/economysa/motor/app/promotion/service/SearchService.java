package com.economysa.motor.app.promotion.service;

import com.economysa.motor.app.core.controller.request.SearchSaveRequest;
import com.economysa.motor.app.promotion.controller.response.SearchResponse;
import com.economysa.motor.app.promotion.entity.Search;

public interface SearchService {

  SearchResponse list(String type, Long mechanic_id);
  SearchResponse create(String createUser, SearchSaveRequest request);
  SearchResponse update(String createUser, SearchSaveRequest request);
  SearchResponse delete(String updateUser, Long id);
  Search get(Long id);
}
