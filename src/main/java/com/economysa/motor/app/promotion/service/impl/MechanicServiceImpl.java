package com.economysa.motor.app.promotion.service.impl;

import com.economysa.motor.app.promotion.controller.request.MechanicRequest;
import com.economysa.motor.app.promotion.entity.Mechanic;
import com.economysa.motor.app.promotion.repository.MechanicRepository;
import com.economysa.motor.app.promotion.service.MechanicService;
import com.economysa.motor.error.exception.BadRequestException;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import com.economysa.motor.util.ConstantMessage;
import com.economysa.motor.util.UtilCore;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class MechanicServiceImpl implements MechanicService {

  @Autowired private MechanicRepository repository;

  private Mechanic init() {
    Mechanic mechanic = new Mechanic();
    mechanic.setCreationDate(UtilCore.UtilDate.fechaActual());
    mechanic.setStatus(Boolean.TRUE);
    return mechanic;
  }

  private Mechanic init(String creationUser, MechanicRequest request) {
    Mechanic mechanic = init();
    mechanic = setData(mechanic, request);
    mechanic.setCreationUser(creationUser);
    mechanic.setCreationDate(UtilCore.UtilDate.fechaActual());
    return mechanic;
  }

  private Mechanic setData(Mechanic mechanic, MechanicRequest request) {
    mechanic.setMechanicType(request.getMechanicType());
    mechanic.setMechanicModality(request.getMechanicModality());
    mechanic.setMechanicUnit(request.getMechanicUnit());
    mechanic.setFactor(request.getFactor());
    mechanic.setBonusQuantity(request.getBonusQuantity());
    mechanic.setPercentageDiscount(request.getPercentageDiscount());
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
    validateRequest(request);
    Mechanic mechanic = init(creationUser, request);

    return repository.save(mechanic);
  }

  @Override
  public Mechanic update(Long id, String updateUser, MechanicRequest request) {
    Mechanic mechanic = get(id);
    validateRequest(request);

    mechanic.setFactor(request.getFactor());
    mechanic.setBonusQuantity(request.getBonusQuantity());
    mechanic.setPercentageDiscount(request.getPercentageDiscount());
    mechanic.setUpdateUser(updateUser);
    mechanic.setUpdateDate(UtilCore.UtilDate.fechaActual());

    return repository.save(mechanic);
  }

  @Override
  public Mechanic delete(String updateUser, Long id) {
    Mechanic mechanic = get(id);
    mechanic.setStatus(Boolean.FALSE);
    mechanic.setUpdateUser(updateUser);
    mechanic.setUpdateDate(UtilCore.UtilDate.fechaActual());

    return repository.save(mechanic);
  }

  private void validateRequest(MechanicRequest request) {
    validateMechanicType(request);
  }

  private void validateMechanicType(MechanicRequest request) {
    log.info(request);
    if (request.getMechanicType().equals(ConstantMessage.MECHANIC_TYPE_SOLES)
        && request.getPercentageDiscount() == null) {
      log.info("PercentageDiscount cannot be null for MechanicType Soles");
      throw new BadRequestException(ConstantMessage.MECHANIC_ERROR_NULL_PERCENTAGE_DISCOUNT);
    } else if (request.getMechanicType().equals(ConstantMessage.MECHANIC_TYPE_BONUS)) {
      if (request.getFactor() == null || request.getBonusQuantity() == null) {
        log.info("Factor and BonusQuantity must be different from null for MechanicType Bonus");
        throw new BadRequestException(ConstantMessage.MECHANIC_ERROR_NULL_FACTOR_BONUS_QUANTITY);
      }
    }
  }
}
