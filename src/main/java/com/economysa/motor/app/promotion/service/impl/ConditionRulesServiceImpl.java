package com.economysa.motor.app.promotion.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.economysa.motor.app.configuration.repository.QueryFieldRepository;
import com.economysa.motor.app.configuration.repository.QueryOperatorRepository;
import com.economysa.motor.app.promotion.controller.request.ConditionRuleRequest;
import com.economysa.motor.app.promotion.controller.request.ConditionRulesRequest;
import com.economysa.motor.app.promotion.controller.response.ConditionRuleResponse;
import com.economysa.motor.app.promotion.controller.response.ConditionRulesResponse;
import com.economysa.motor.app.promotion.entity.ConditionRules;
import com.economysa.motor.app.promotion.repository.ConditionRulesRepository;
import com.economysa.motor.app.promotion.repository.MechanicRepository;
import com.economysa.motor.app.promotion.service.ConditionRulesService;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import com.economysa.motor.util.ConstantMessage;
import com.economysa.motor.util.UtilCore;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ConditionRulesServiceImpl implements ConditionRulesService {

	  @Autowired private ConditionRulesRepository repository;
	  @Autowired private MechanicRepository mechanicRepository;
	  @Autowired private QueryFieldRepository fieldRepository;
	  @Autowired private QueryOperatorRepository opertatorRepository;

  private ConditionRules init() {
	  ConditionRules cond = new ConditionRules();
	  cond.setCreationDate(UtilCore.UtilDate.fechaActual());
	  cond.setStatus(ConstantMessage.MECHANIC_STATUS_CREATED);
    return cond;
  }

  private ConditionRules init(String creationUser, String type, Long mechanic_id, ConditionRuleRequest request) {
	ConditionRules cond = init();
    cond = setData(type, mechanic_id, cond, request);
    cond.setCreationUser(creationUser);
    return cond;
  }

  private ConditionRules setData(String type, Long mechanic_id, ConditionRules cond,ConditionRuleRequest request) {

	cond.setType(type);
	cond.setMechanic(mechanicRepository.findById(mechanic_id).orElseThrow());
    cond.setField(fieldRepository.findById(request.getField_id()).orElseThrow());
    cond.setOperator(opertatorRepository.findById(request.getOperator_id()).orElseThrow());
    cond.setValue(request.getValue());
    
    return cond;
  }

  
  @Override
  public ConditionRulesResponse list(String type, Long mechanic_id) {

	  ConditionRulesResponse response = new ConditionRulesResponse();
	  List<ConditionRuleResponse> list = new ArrayList<ConditionRuleResponse>();
	  
	  response.setMechanic(mechanic_id);
	  response.setType(type);
	  
	  List<ConditionRules> listConditions = repository.findAll(type, mechanic_id);
	  
	  if(!listConditions.isEmpty()) {
		  		  
		  for(ConditionRules cond: listConditions) {
			  
			  list.add(new ConditionRuleResponse(cond.getId(), cond.getField().getId(), cond.getOperator().getId(), cond.getValue()));
		  }

	  }
	  
	  response.setConditionRules(list);
	  
      return response;
    
  }

  @Override
  public ConditionRules get(Long id) {
    Optional<ConditionRules> obj = repository.findById(id);
    if (!obj.isPresent()) {
      log.info("No ConditionRule entity for ID [ " + id + " ]");
      throw new ResourceNotFoundException(ConstantMessage.MECHANIC_NOT_FOUND);
    }
    return obj.get();
  }

  
  @Override
  public ConditionRulesResponse create(String creationUser, ConditionRulesRequest request) {
	  
	  if(request.getConditionRule()!=null) {
		  
		  ConditionRules obj = init(creationUser, request.getType(), request.getMechanic(), request.getConditionRule());
		  repository.save(obj);
	  
	  }else {
		  
		  log.info("Not found condition in request");
	      throw new ResourceNotFoundException(ConstantMessage.MECHANIC_NOT_FOUND);
	      
	  }
	  
	    return this.list(request.getType(), request.getMechanic());
	   
  }

  @Override
  public ConditionRulesResponse createConditions(String creationUser, ConditionRulesRequest request) {
	  
	  if(request.getConditionRules()!=null && !request.getConditionRules().isEmpty()) {
		
		  for(ConditionRuleRequest req : request.getConditionRules()) {
			  
			  ConditionRules obj = init(creationUser, request.getType(), request.getMechanic(), req);
			  repository.save(obj);
		  }
		  
	  }else {
		  
		  log.info("Not found conditions in request");
	      throw new ResourceNotFoundException(ConstantMessage.MECHANIC_NOT_FOUND);
	      
	  }

	  
    return this.list(request.getType(), request.getMechanic());
  }
  
  @Override
  public ConditionRulesResponse delete(String updateUser, Long id) {
	  
    ConditionRules obj = get(id);
    obj.setStatus(ConstantMessage.MECHANIC_STATUS_DELETED);
    obj.setUpdateUser(updateUser);
    obj.setUpdateDate(UtilCore.UtilDate.fechaActual());
    repository.save(obj);
    
    return this.list(obj.getType(), obj.getMechanic().getId());
  }

  
}
