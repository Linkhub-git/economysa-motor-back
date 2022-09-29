package com.economysa.motor.app.promotion.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.economysa.motor.app.core.controller.request.SearchConditionRequest;
import com.economysa.motor.app.core.controller.request.SearchGroupRequest;
import com.economysa.motor.app.core.controller.request.SearchRequest;
import com.economysa.motor.app.core.controller.request.SearchSaveRequest;
import com.economysa.motor.app.promotion.controller.response.SearchConditionResponse;
import com.economysa.motor.app.promotion.controller.response.SearchGroupResponse;
import com.economysa.motor.app.promotion.controller.response.SearchResponse;
import com.economysa.motor.app.promotion.controller.response.SearchRulesResponse;
import com.economysa.motor.app.promotion.entity.Search;
import com.economysa.motor.app.promotion.entity.SearchCondition;
import com.economysa.motor.app.promotion.entity.SearchGroup;
import com.economysa.motor.app.promotion.repository.SearchRepository;
import com.economysa.motor.app.promotion.service.MechanicService;
import com.economysa.motor.app.promotion.service.SearchConditionService;
import com.economysa.motor.app.promotion.service.SearchGroupService;
import com.economysa.motor.app.promotion.service.SearchService;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import com.economysa.motor.error.exception.UserAlreadyExistsException;
import com.economysa.motor.util.ConstantMessage;
import com.economysa.motor.util.UtilCore;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class SearchServiceImpl implements SearchService {

	  @Autowired private SearchRepository repository;
	  @Autowired private MechanicService mechanicService;
	  @Autowired private SearchGroupService searchGroupService;
	  @Autowired private SearchConditionService searchConditionService;

  private Search init() {
	  Search cond = new Search();
	  cond.setCreationDate(UtilCore.UtilDate.fechaActual());
	  cond.setStatus(ConstantMessage.MECHANIC_STATUS_CREATED);
    return cond;
  }

  private Search init(String creationUser, SearchSaveRequest request) {
	  Search cond = init();
    cond = setData(cond, request);
    cond.setCreationUser(creationUser);
    return cond;
  }

  private Search setData(Search cond,SearchSaveRequest request) {

	cond.setMechanic(mechanicService.get(request.getMechanic()));
    cond.setType(request.getType());
    cond.setSearchOperator(request.getSearchRules().getSearchOperator());
    
    return cond;
  }

  
  @Override
  public SearchResponse list(String type, Long mechanic_id) {

	  SearchResponse searchResponse = new SearchResponse();
	  SearchRulesResponse searchRulesResponse = null;
	  List<SearchGroupResponse> listGroup = new ArrayList<SearchGroupResponse>();
	  List<SearchConditionResponse> listCondition = new ArrayList<SearchConditionResponse>();
	  
	  Optional<Search> optional = repository.findAll(type, mechanic_id);
	  Search search = null;
	  
	  searchResponse.setMechanic(mechanic_id);
	  searchResponse.setType(type);
	  
	  if (optional.isPresent()) {
		  		  
		  search = optional.get();
		  
		  searchRulesResponse = new SearchRulesResponse();
		  searchRulesResponse.setSearchId(search.getId());
		  searchRulesResponse.setSearchOperator(search.getSearchOperator());
		
		  if(search.getGroups()!=null && !search.getGroups().isEmpty()) {

				  for(SearchGroup group: search.getGroups()) {
					  					  
					  if(group.getConditions()!=null && !group.getConditions().isEmpty() && !group.getStatus().equals(ConstantMessage.MECHANIC_STATUS_DELETED)) {
				  		  
						  listCondition = new ArrayList<SearchConditionResponse>();

						  for(SearchCondition cond: group.getConditions()) {
		
							  if(!cond.getStatus().equals(ConstantMessage.MECHANIC_STATUS_DELETED)) {

							  listCondition.add(new SearchConditionResponse(cond.getId(), cond.getField().getId(), cond.getOperator().getId(), cond.getValue()));
							  
							  }
						  }
						  
						  listGroup.add(new SearchGroupResponse(group.getId(), group.getGroupOperator(), listCondition));

					  }
					  
					  
				  }
		  }
		  
		  searchRulesResponse.setGroups(listGroup);

	  }

	  searchResponse.setSearchRules(searchRulesResponse);
	  	  
      return searchResponse;
    
  }

  @Override
  public Search get(Long id) {
    Optional<Search> obj = repository.findById(id);
    if (!obj.isPresent()) {
      log.info("No SearchRule entity for ID [ " + id + " ]");
      throw new ResourceNotFoundException(ConstantMessage.SEARCH_NOT_FOUND);
    }
    return obj.get();
  }

  @Override
  public SearchResponse create(String creationUser, SearchSaveRequest request) {

	  
	  	  Optional<Search> optional = repository.findAll(request.getType(), request.getMechanic());

	  	  if (optional.isPresent()) {
	        log.info("Ya existe una regla para [ " + request.getMechanic() + " / " + request.getType() + " ]");
	        throw new UserAlreadyExistsException(ConstantMessage.ITEM_ALREADY_ADDED);
	      }
	  	  
	  	  Search obj = init(creationUser, request);
	  	  
	  	  obj = repository.save(obj);
	  	  
		
		  if(request.getSearchRules().getGroups()!=null && !request.getSearchRules().getGroups().isEmpty()) {

				  for(SearchGroupRequest group: request.getSearchRules().getGroups()) {
					  
					  createGroupConditions(creationUser, group, obj.getId());
					 					  
				  }
		  }
	  
	  
	    return this.list(request.getType(), request.getMechanic());
	   
  }

  
  private void createGroupConditions(String creationUser, SearchGroupRequest group, Long searchId){
	  
	  SearchGroup searchGroup = searchGroupService.create(creationUser,group, searchId);
	  
	  if(group.getConditions()!=null && !group.getConditions().isEmpty()) {
  		  
		  for(SearchConditionRequest cond: group.getConditions()) {
			  
			  searchConditionService.create(creationUser,cond,searchGroup.getId());

		  }
		  
	  }
	  
  }
  
  @Override
  public SearchResponse update(String updateUser, SearchSaveRequest request) {
	  

	  Search search = null;
	  
  	  Optional<Search> optional = repository.findAll(request.getType(), request.getMechanic());

  	  if (!optional.isPresent()) {
        log.info("No existe una regla para [ " + request.getMechanic() + " / " + request.getType() + " ]");
        throw new ResourceNotFoundException(ConstantMessage.SEARCH_NOT_FOUND);
      }else {
    	  
    	  search = optional.get();
      }
  	  
  	  Search obj = this.setData(search, request);
  	  obj.setUpdateDate(UtilCore.UtilDate.fechaActual());
  	  obj.setUpdateUser(updateUser);
  	  
  	  obj = repository.save(obj);
  	  
  	  Map<Long,Long> mapGroups = searchGroupService.findBySearchId(obj.getId());
  	  Map<Long,Long> mapConditions = searchConditionService.findBySearchId(obj.getId());
  			  
	  if(request.getSearchRules().getGroups()!=null && !request.getSearchRules().getGroups().isEmpty()) {

			  for(SearchGroupRequest group: request.getSearchRules().getGroups()) {
				  					  
				  if(group.getGroupId()==null) {
					  
					  createGroupConditions(updateUser, group, obj.getId());
					  
				  }else {
					  
					  SearchGroup searchGroup = searchGroupService.update(updateUser, group);
					  
					  mapGroups.remove(group.getGroupId());
					  
					  if(group.getConditions()!=null && !group.getConditions().isEmpty()) {
				  		  
						  for(SearchConditionRequest cond: group.getConditions()) {
							  
							  if(cond.getConditionId()==null){
								  
								  searchConditionService.create(updateUser,cond,searchGroup.getId());

							  }else {
								  
								  searchConditionService.update(updateUser, cond);
								  
								  mapConditions.remove(cond.getConditionId());
							  }
							  

						  }
						  
					  }
				  }
				  
			  }
	  }
	  
	  mapGroups.forEach((k,v) -> searchGroupService.delete(updateUser,k));
	  mapConditions.forEach((k,v) -> searchConditionService.delete(updateUser,k));


	  
    return this.list(request.getType(), request.getMechanic());
    
  }

  
  @Override
  public SearchResponse delete(String updateUser, Long id) {
	  
    Search obj = get(id);
    obj.setStatus(ConstantMessage.MECHANIC_STATUS_DELETED);
    obj.setUpdateUser(updateUser);
    obj.setUpdateDate(UtilCore.UtilDate.fechaActual());
    repository.save(obj);
    
    return this.list(obj.getType(), obj.getMechanic().getId());
  }

  
}
