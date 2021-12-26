package com.economysa.motor.app.promotion.service.impl;

import com.economysa.motor.app.promotion.controller.request.MechanicRequest;
import com.economysa.motor.app.promotion.entity.Mechanic;
import com.economysa.motor.app.promotion.repository.MechanicRepository;
import com.economysa.motor.app.promotion.service.MechanicService;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import com.economysa.motor.util.ConstantMessage;
import com.economysa.motor.util.UtilCore;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Log4j2
public class MechanicServiceImpl implements MechanicService {

  @Autowired private MechanicRepository repository;

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
    mechanic.setDescription(request.getDescription());
    mechanic.setStartDate(new Date(request.getStartDate()));
    mechanic.setEndDate(new Date(request.getEndDate()));
    mechanic.setAccumulate(request.getAccumulate());
    mechanic.setPromotionType(request.getPromotionType());
    mechanic.setType(request.getType());
    mechanic.setRange1(request.getRange1());
    mechanic.setRange2(request.getRange2());
    mechanic.setFactor(request.getFactor());
    mechanic.setConditional(request.getConditional());
    return mechanic;
  }

  @Override
  public Page<Mechanic> list(Pageable pageable) {
    return repository.findAll(pageable);
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
}
