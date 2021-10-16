package com.economysa.motor.app.config.service.impl;

import com.economysa.motor.app.config.entity.PromotionType;
import com.economysa.motor.app.config.repository.PromotionTypeRepository;
import com.economysa.motor.app.config.service.PromotionTypeService;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import com.economysa.motor.util.ConstantMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class PromotionTypeServiceImpl implements PromotionTypeService {

  @Autowired private PromotionTypeRepository repository;

  @Override
  public List<PromotionType> list() {
    return repository.findAll();
  }

  @Override
  public PromotionType get(Long id) {
    Optional<PromotionType> promotionType = repository.findById(id);
    if (!promotionType.isPresent()) {
      log.info("No PromotionType entity for ID [ " + id + " ]");
      throw new ResourceNotFoundException(ConstantMessage.PROMOTION_TYPE_NOT_FOUND);
    }
    return promotionType.get();
  }
}
