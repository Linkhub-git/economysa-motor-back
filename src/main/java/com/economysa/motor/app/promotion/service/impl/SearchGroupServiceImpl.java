package com.economysa.motor.app.promotion.service.impl;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.economysa.motor.app.core.controller.request.SearchGroupRequest;
import com.economysa.motor.app.promotion.controller.response.SearchResponse;
import com.economysa.motor.app.promotion.entity.SearchGroup;
import com.economysa.motor.app.promotion.repository.SearchGroupRepository;
import com.economysa.motor.app.promotion.service.SearchGroupService;
import com.economysa.motor.app.promotion.service.SearchService;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import com.economysa.motor.util.ConstantMessage;
import com.economysa.motor.util.UtilCore;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class SearchGroupServiceImpl implements SearchGroupService {

	  @Autowired private SearchGroupRepository repository;
	  @Autowired private SearchService service;

	  private SearchGroup init() {
		  SearchGroup cond = new SearchGroup();
		  cond.setCreationDate(UtilCore.UtilDate.fechaActual());
		  cond.setStatus(ConstantMessage.MECHANIC_STATUS_CREATED);
	    return cond;
	  }

	  private SearchGroup init(String creationUser, SearchGroupRequest request, Long searchId) {
		  SearchGroup group = init();
		  group = setData(group, request, searchId);
		  group.setCreationUser(creationUser);
	    return group;
	  }

	  private SearchGroup setData(SearchGroup group, SearchGroupRequest request, Long searchId) {

		  group.setGroupOperator(request.getGroupOperator());
		  group.setSearch(service.get(searchId));
		  
	    return group;
	  }
	  
	  public SearchGroup create(String creationUser, SearchGroupRequest request, Long searchId) {

		  SearchGroup obj = init(creationUser, request, searchId);
	  	  obj = repository.save(obj);

	  	  return obj;
	  	  
	  }
	  
	  public SearchGroup update(String updateUser, SearchGroupRequest request) {

		  SearchGroup obj = get(request.getGroupId());

		  obj = setData(obj, request, obj.getSearch().getId());
		  obj.setUpdateUser(updateUser);
		  obj.setUpdateDate(UtilCore.UtilDate.fechaActual());
	    
		  return repository.save(obj);
	  	  
	  }
	  
	  @Override
	  public SearchResponse delete(String updateUser, Long id) {
		  
	    SearchGroup obj = get(id);
	    obj.setStatus(ConstantMessage.MECHANIC_STATUS_DELETED);
	    obj.setUpdateUser(updateUser);
	    obj.setUpdateDate(UtilCore.UtilDate.fechaActual());
	    repository.save(obj);
	    
	    return service.list(obj.getSearch().getType(), obj.getSearch().getMechanic().getId());

	  }
	  

	  @Override
	  public SearchGroup get(Long id) {
	    Optional<SearchGroup> obj = repository.findById(id);
	    if (!obj.isPresent()) {
	      log.info("No ConditionRule entity for ID [ " + id + " ]");
	      throw new ResourceNotFoundException(ConstantMessage.GROUP_NOT_FOUND);
	    }
	    return obj.get();
	  }

	@Override
	public Map<Long,Long> findBySearchId(Long searchId) {
		
		Map<Long,Long> map = repository.findBySearchId(searchId).stream().collect(Collectors.toMap(SearchGroup::getId, SearchGroup::getId));
		
		return map;
	}
}
