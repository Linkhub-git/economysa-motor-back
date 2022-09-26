package com.economysa.motor.app.promotion.service.impl;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.economysa.motor.app.configuration.service.QueryFieldService;
import com.economysa.motor.app.configuration.service.QueryOperatorService;
import com.economysa.motor.app.core.controller.request.SearchConditionRequest;
import com.economysa.motor.app.promotion.controller.response.SearchResponse;
import com.economysa.motor.app.promotion.entity.SearchCondition;
import com.economysa.motor.app.promotion.repository.SearchConditionRepository;
import com.economysa.motor.app.promotion.service.SearchConditionService;
import com.economysa.motor.app.promotion.service.SearchGroupService;
import com.economysa.motor.app.promotion.service.SearchService;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import com.economysa.motor.util.ConstantMessage;
import com.economysa.motor.util.UtilCore;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class SearchConditionServiceImpl implements SearchConditionService {

	  @Autowired private SearchConditionRepository repository;
	  @Autowired private SearchGroupService service;
	  @Autowired private SearchService searchService;
	  @Autowired private QueryFieldService fieldService;
	  @Autowired private QueryOperatorService operatorService;

	  private SearchCondition init() {
		  SearchCondition cond = new SearchCondition();
		  cond.setCreationDate(UtilCore.UtilDate.fechaActual());
		  cond.setStatus(ConstantMessage.MECHANIC_STATUS_CREATED);
	    return cond;
	  }

	  private SearchCondition init(String creationUser, SearchConditionRequest request, Long groupId) {
		SearchCondition cond = init();
	    cond = setData(cond, request, groupId);
	    cond.setCreationUser(creationUser);
	    return cond;
	  }

	  private SearchCondition setData(SearchCondition cond, SearchConditionRequest request, Long groupId) {

		cond.setSearchGroup(service.get(groupId));
	    cond.setField(fieldService.get(request.getFieldId()));
	    cond.setOperator(operatorService.get(request.getOperatorId()));
	    cond.setValue(request.getValue());
	    
	    return cond;
	  }
	  
	  public SearchCondition create(String creationUser, SearchConditionRequest request, Long groupId) {

		  SearchCondition obj = init(creationUser, request, groupId);

		  return repository.save(obj);
	  	  
	  }
	  
	  public SearchCondition update(String updateUser, SearchConditionRequest request) {

		SearchCondition obj = get(request.getConditionId());

		obj = setData(obj, request, obj.getSearchGroup().getId());
		obj.setUpdateUser(updateUser);
		obj.setUpdateDate(UtilCore.UtilDate.fechaActual());
	    
	    return repository.save(obj);
	  	  
	  }
	  
	  @Override
	  public SearchResponse delete(String updateUser, Long id) {
		  
	    SearchCondition obj = get(id);
	    obj.setStatus(ConstantMessage.MECHANIC_STATUS_DELETED);
	    obj.setUpdateUser(updateUser);
	    obj.setUpdateDate(UtilCore.UtilDate.fechaActual());
	    repository.save(obj);
	    
	    return searchService.list(obj.getSearchGroup().getSearch().getType(), obj.getSearchGroup().getSearch().getMechanic().getId());

	  }


	  @Override
	  public SearchCondition get(Long id) {
	    Optional<SearchCondition> obj = repository.findById(id);
	    if (!obj.isPresent()) {
	      log.info("No ConditionRule entity for ID [ " + id + " ]");
	      throw new ResourceNotFoundException(ConstantMessage.CONDITION_NOT_FOUND);
	    }
	    return obj.get();
	  }

	@Override
	public Map<Long, Long> findBySearchId(Long searchId) {
		
		Map<Long, Long> map = repository.findBySearchId(searchId).stream().collect(Collectors.toMap(SearchCondition::getId, SearchCondition::getId));
		
		return map;
	}


  
}
