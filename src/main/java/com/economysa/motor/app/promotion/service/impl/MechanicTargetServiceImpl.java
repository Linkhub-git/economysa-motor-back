package com.economysa.motor.app.promotion.service.impl;

import com.economysa.motor.app.core.service.ProductService;
import com.economysa.motor.app.core.service.ProviderService;
import com.economysa.motor.app.promotion.controller.request.MechanicTargetRequest;
import com.economysa.motor.app.promotion.entity.Mechanic;
import com.economysa.motor.app.promotion.entity.MechanicTarget;
import com.economysa.motor.app.promotion.repository.MechanicTargetRepository;
import com.economysa.motor.app.promotion.service.MechanicProductService;
import com.economysa.motor.app.promotion.service.MechanicService;
import com.economysa.motor.app.promotion.service.MechanicTargetService;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import com.economysa.motor.util.ConstantMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class MechanicTargetServiceImpl implements MechanicTargetService {

  @Autowired private MechanicTargetRepository repository;
  @Autowired private MechanicProductService mechanicProductService;
  @Autowired private MechanicService mechanicService;
  @Autowired private ProviderService providerService;
  @Autowired private ProductService productService;

  private MechanicTarget init(MechanicTargetRequest request) {
    MechanicTarget target = new MechanicTarget();
    target.setTargetId(request.getTargetId());
    target.setMechanic(request.getMechanic());
    return target;
  }

  @Override
  public List<MechanicTarget> list(Long mechanicId) {
    Mechanic mechanic = mechanicService.get(mechanicId);
    List<MechanicTarget> items = repository.findByMechanic(mechanicId);
    items.forEach(mt -> {
      if (mechanic.getMechanicModality().equals(ConstantMessage.MECHANIC_MODALITY_PROVIDER)) {
        mt.setTargetName(providerService.get(mt.getTargetId()).getName());
      } else {
        mt.setTargetName(productService.get(mt.getTargetId()).getName());
      }
    });
    return items;
  }

  @Override
  public MechanicTarget get(Long id) {
    Optional<MechanicTarget> target = repository.findByTargetId(id);
    if (!target.isPresent()) {
      log.info("No MechanicTarget entity for ID [ " + target + " ]");
      throw new ResourceNotFoundException(ConstantMessage.MECHANIC_TARGET_NOT_FOUND);
    }
    return target.get();
  }

  @Transactional
  @Override
  public MechanicTarget create(MechanicTargetRequest request) {
    MechanicTarget target = init(request);
    target = repository.save(target);

    Mechanic mechanic = mechanicService.get(target.getMechanic());
    mechanicProductService.addProductsForMechanic(target.getMechanic(),
        mechanic.getMechanicModality(), target.getTargetId());

    return target;
  }

  @Transactional
  @Override
  public MechanicTarget delete(Long id) {
    MechanicTarget target = get(id);
    repository.delete(target);

    Mechanic mechanic = mechanicService.get(target.getMechanic());
    mechanicProductService.deleteProductsForMechanic(target.getMechanic(),
        mechanic.getMechanicModality());

    return new MechanicTarget();
  }
}
