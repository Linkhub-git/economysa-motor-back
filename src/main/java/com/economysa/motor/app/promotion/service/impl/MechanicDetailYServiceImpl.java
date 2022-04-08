package com.economysa.motor.app.promotion.service.impl;

import com.economysa.motor.app.configuration.service.BrandService;
import com.economysa.motor.app.configuration.service.CategoryService;
import com.economysa.motor.app.core.service.ProductService;
import com.economysa.motor.app.core.service.ProviderService;
import com.economysa.motor.app.promotion.controller.request.MechanicDetailYRequest;
import com.economysa.motor.app.promotion.entity.MechanicDetailY;
import com.economysa.motor.app.promotion.repository.MechanicDetailYRepository;
import com.economysa.motor.app.promotion.service.MechanicDetailYService;
import com.economysa.motor.app.promotion.service.MechanicService;
import com.economysa.motor.error.exception.BadRequestException;
import com.economysa.motor.util.ConstantMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class MechanicDetailYServiceImpl implements MechanicDetailYService {

  @Autowired private MechanicDetailYRepository repository;
  @Autowired private MechanicService mechanicService;

  @Autowired private ProviderService providerService;
  @Autowired private ProductService productService;
  @Autowired private CategoryService categoryService;
  @Autowired private BrandService brandService;

  private MechanicDetailY init(MechanicDetailYRequest request) {
    MechanicDetailY detail = new MechanicDetailY();
    detail.setMechanic(mechanicService.get(request.getMechanic()));
    detail.setType(request.getType());
    detail.setIdentifier(request.getIdentifier());
    detail.setCode(request.getCode());
    detail.setDescription(request.getDescription());
    return detail;
  }

  @Override
  public List<MechanicDetailY> list(Long mechanicId) {
    return repository.findAll(mechanicId);
  }

  @Override
  public MechanicDetailY add(MechanicDetailYRequest request) {
    MechanicDetailY detail = init(request);
    validateRequest(request);
    return repository.save(detail);
  }

  private void validateRequest(MechanicDetailYRequest request) {
    if (repository.findByMechanicAndTypeAndIdentifier(request.getMechanic(),
          request.getType(), request.getIdentifier()).isPresent()) {
      log.info(ConstantMessage.ITEM_ALREADY_ADDED);
      throw new BadRequestException(ConstantMessage.ITEM_ALREADY_ADDED);
    }

    // Valida el identificador
    if (request.getType().equals(ConstantMessage.MECHANIC_TYPE_PROVIDER)) {
      providerService.get(request.getIdentifier());
    } else if (request.getType().equals(ConstantMessage.MECHANIC_TYPE_ARTICLE)) {
      productService.get(request.getIdentifier());
    } else if (request.getType().equals(ConstantMessage.MECHANIC_TYPE_CATEGORY)) {
      categoryService.get(request.getIdentifier());
    } else if (request.getType().equals(ConstantMessage.MECHANIC_TYPE_BRAND)) {
      brandService.get(request.getIdentifier());
    } else {
      throw new IllegalArgumentException("Invalid Mechanic Type");
    }
  }
}
