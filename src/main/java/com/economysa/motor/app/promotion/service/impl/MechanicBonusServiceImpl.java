package com.economysa.motor.app.promotion.service.impl;

import com.economysa.motor.app.core.entity.Product;
import com.economysa.motor.app.core.service.ProductService;
import com.economysa.motor.app.promotion.controller.request.MechanicBonusRequest;
import com.economysa.motor.app.promotion.controller.request.MechanicValidateRequest;
import com.economysa.motor.app.promotion.entity.MechanicBonus;
import com.economysa.motor.app.promotion.repository.MechanicBonusRepository;
import com.economysa.motor.app.promotion.service.MechanicBonusService;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import com.economysa.motor.util.ConstantMessage;
import com.economysa.motor.util.UtilCore;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class MechanicBonusServiceImpl implements MechanicBonusService {

  @Autowired private MechanicBonusRepository repository;
  @Autowired private ProductService productService;

  private MechanicBonus init() {
    MechanicBonus bonus = new MechanicBonus();
    bonus.setCreationDate(UtilCore.UtilDate.fechaActual());
    bonus.setStock(BigDecimal.ZERO);
    bonus.setStatus(Boolean.TRUE);
    return bonus;
  }

  private MechanicBonus init(String creationUser, MechanicBonusRequest request) {
    MechanicBonus bonus = init();
    bonus.setProduct(productService.get(request.getProductId()));
    bonus.setMechanic(request.getMechanic());
    bonus.setStock(request.getStock());
    bonus.setCreationUser(creationUser);
    return bonus;
  }

  @Override
  public List<MechanicBonus> list(Long mechanicId) {
    return repository.findByMechanic(mechanicId);
  }

  @Override
  public MechanicBonus get(Long id) {
    Optional<MechanicBonus> bonus = repository.findById(id);
    if (!bonus.isPresent()) {
      log.info("No MechanicBonus entity for ID [ " + id + " ]");
      throw new ResourceNotFoundException(ConstantMessage.MECHANIC_BONUS_NOT_FOUND);
    }
    return bonus.get();
  }

  @Override
  public MechanicBonus create(String creationUser, MechanicBonusRequest request) {
    MechanicBonus bonus = init(creationUser, request);

    return repository.save(bonus);
  }

  @Override
  public MechanicBonus update(String updateUser, Long id, MechanicBonusRequest request) {
    MechanicBonus bonus = get(id);
    bonus.setStock(request.getStock());
    bonus.setUpdateUser(updateUser);
    bonus.setUpdateDate(UtilCore.UtilDate.fechaActual());

    return repository.save(bonus);
  }

  @Override
  public MechanicBonus delete(String updateUser, Long id) {
    MechanicBonus bonus = get(id);
    bonus.setStatus(Boolean.FALSE);
    bonus.setUpdateUser(updateUser);
    bonus.setUpdateDate(UtilCore.UtilDate.fechaActual());

    return repository.save(bonus);
  }
}
