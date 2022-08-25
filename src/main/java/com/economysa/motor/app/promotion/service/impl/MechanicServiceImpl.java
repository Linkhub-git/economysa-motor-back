package com.economysa.motor.app.promotion.service.impl;

import java.sql.Time;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.economysa.motor.app.core.service.ProviderService;
import com.economysa.motor.app.promotion.controller.request.MechanicRequest;
import com.economysa.motor.app.promotion.entity.Mechanic;
import com.economysa.motor.app.promotion.repository.MechanicRepository;
import com.economysa.motor.app.promotion.service.MechanicService;
import com.economysa.motor.error.exception.BadRequestException;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import com.economysa.motor.util.ConstantMessage;
import com.economysa.motor.util.UtilCore;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class MechanicServiceImpl implements MechanicService {

  @Autowired private MechanicRepository repository;
  @Autowired private ProviderService providerService;

  private Mechanic init() {
    Mechanic mechanic = new Mechanic();
    mechanic.setCreationDate(UtilCore.UtilDate.fechaActual());
    mechanic.setStatus(ConstantMessage.MECHANIC_STATUS_CREATED);
    return mechanic;
  }

  private Mechanic init(String creationUser, MechanicRequest request) {
    Mechanic mechanic = init();
    mechanic = setData(mechanic, request);
    mechanic.setCode(generateMechanicCode());
    mechanic.setCreationUser(creationUser);
    mechanic.setCreationDate(UtilCore.UtilDate.fechaActual());
    return mechanic;
  }

  private Mechanic setData(Mechanic mechanic, MechanicRequest request) {
    mechanic.setProviderDescription(request.getProviderDescription());
    mechanic.setCatalogDescription(request.getCatalogDescription());
    mechanic.setStartDate(fecha(request.getStartDate()));
    mechanic.setEndDate(fecha(request.getEndDate()));
    mechanic.setStartTime(Time.valueOf(request.getStartTime()));
    mechanic.setEndTime(Time.valueOf(request.getEndTime()));
    mechanic.setAccumulate(getAccumulate(request.getAccumulate()));
    mechanic.setPromotionType(getPromotionType(request.getPromotionType()));
    mechanic.setType(getType(request.getType()));
    mechanic.setConditional(request.getConditional());
    mechanic.setEmitter(request.getEmitter());
    
    
    if (request.getEmitter().equals(ConstantMessage.EMITTER_PROVIDER) ) {
    	
    	if(request.getEmitterId()==null) {
    		
    		log.info("EmitterId is mandatory for emitter [ " + request.getEmitter() + " ]");
            throw new ResourceNotFoundException(ConstantMessage.ERROR_BAD_REQUEST + " - emitterId is mandatory");
            
    	}else {
    		
    	      mechanic.setEmitterObj(providerService.get(request.getEmitterId()));

    	}

    }
    
    return mechanic;
  }

  @Override
  public Page<Mechanic> list(String emitter, Pageable pageable) {
    if (emitter != null && !emitter.isEmpty()) {
      return repository.find(emitter, pageable);
    } else {
      return repository.findAll(pageable);
    }
  }

  @Override
  public Mechanic get(Long id) {
    Optional<Mechanic> mechanic = repository.findById(id);
    if (!mechanic.isPresent()) {
      log.info("No Mechanic entity for ID [ " + id + " ]");
      throw new ResourceNotFoundException(ConstantMessage.MECHANIC_NOT_FOUND);
    }
    return mechanic.get();
  }

  @Override
  public Mechanic create(String creationUser, MechanicRequest request) {
    Mechanic mechanic = init(creationUser, request);
    return repository.save(mechanic);
  }

  @Override
  public Mechanic update(Long id, String updateUser, MechanicRequest request) {
    log.info("Update mechanic: " + request);
    Mechanic mechanic = get(id);

    mechanic = setData(mechanic, request);
    mechanic.setUpdateUser(updateUser);
    mechanic.setUpdateDate(UtilCore.UtilDate.fechaActual());

    return repository.save(mechanic);
  }

  @Override
  public Mechanic delete(String updateUser, Long id) {
    Mechanic mechanic = get(id);
    mechanic.setStatus(ConstantMessage.MECHANIC_STATUS_DELETED);
    mechanic.setUpdateUser(updateUser);
    mechanic.setUpdateDate(UtilCore.UtilDate.fechaActual());

    return repository.save(mechanic);
  }

  private String generateMechanicCode() {
    long cant = repository.count() + 1;
    cant = cant + 10000;
    int n0 = 7 - String.valueOf(cant).length();
    String zero = "";
    for (int i = 0; i < n0; i++) {
      zero += "0";
    }
    return zero + cant;
  }

  private String getAccumulate(String accumulate) {
    if (accumulate.equals(ConstantMessage.MECHANIC_TYPE_SOL) ||
          accumulate.equals(ConstantMessage.MECHANIC_TYPE_UNIT)) {
      return accumulate;
    } else {
      throw new BadRequestException("Invalid accumulate value: [ " + accumulate + " ]");
    }
  }

  private String getPromotionType(String promotionType) {
    if (promotionType.equals(ConstantMessage.MECHANIC_PROMOTION_TYPE_DISCOUNT) ||
          promotionType.equals(ConstantMessage.MECHANIC_PROMOTION_TYPE_PRODUCT)) {
      return promotionType;
    } else {
      throw new BadRequestException("Invalid promotionType value: [ " + promotionType + " ]");
    }
  }

  private String getType(String type) {
    if (type.equals(ConstantMessage.MECHANIC_TYPE_RANGE) ||
          type.equals(ConstantMessage.MECHANIC_TYPE_FACTOR) ||
          type.equals(ConstantMessage.MECHANIC_TYPE_RANGE_FACTOR)) {
      return type;
    } else {
      throw new BadRequestException("Invalid type value: [ " + type + " ]");
    }
  }

  private java.sql.Date fecha(String fecha) {
	  
	  java.sql.Date fec = new java.sql.Date(0);
	  
	  try {
		  
		  fec = fec.valueOf(fecha);
				
		  return fec;
		  
	  }catch(Exception e) {
		  
	      throw new BadRequestException("Invalid date value: [ " + fecha + " ]");

	  }
	  
  }
}
