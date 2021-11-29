package com.economysa.motor.app.promotion.service.impl;

import com.economysa.motor.app.core.service.ProductService;
import com.economysa.motor.app.promotion.controller.request.MechanicBonusRequest;
import com.economysa.motor.app.promotion.entity.MechanicBonus;
import com.economysa.motor.app.promotion.repository.MechanicBonusRepository;
import com.economysa.motor.app.promotion.service.MechanicBonusService;
import com.economysa.motor.app.promotion.service.MechanicService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Log4j2
public class MechanicBonusServiceImpl implements MechanicBonusService {

  @Autowired private MechanicBonusRepository repository;
  @Autowired private MechanicService mechanicService;
  @Autowired private ProductService productService;

  private MechanicBonus init(MechanicBonusRequest request) {
    MechanicBonus bonus = new MechanicBonus();
    bonus.setMechanic(mechanicService.get(request.getMechanic()));
    bonus.setPercentageDiscount(request.getPercentageDiscount());
    bonus.setBonusQuantity(request.getBonusQuantity());
    bonus.setBonusMax(request.getBonusMax());
    bonus.setProduct(productService.get(request.getProduct()));
    bonus.setPriority(request.getPriority());
    bonus.setQuantityUse(BigDecimal.ZERO);
    return bonus;
  }

  @Override
  public List<MechanicBonus> list(Long mechanicId) {
    return repository.findAll(mechanicId);
  }

  @Override
  public MechanicBonus add(MechanicBonusRequest request) {
    MechanicBonus bonus = init(request);
    return repository.save(bonus);
  }
}
