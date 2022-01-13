package com.economysa.motor.app.promotion.service.impl;

import com.economysa.motor.app.promotion.controller.request.MechanicDetailRequest;
import com.economysa.motor.app.promotion.entity.MechanicDetail;
import com.economysa.motor.app.promotion.repository.MechanicDetailRepository;
import com.economysa.motor.app.promotion.service.MechanicDetailService;
import com.economysa.motor.app.promotion.service.MechanicService;
import com.economysa.motor.error.exception.BadRequestException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class MechanicDetailServiceImpl implements MechanicDetailService {

  @Autowired private MechanicDetailRepository repository;
  @Autowired private MechanicService mechanicService;

  private MechanicDetail init(MechanicDetailRequest request) {
    MechanicDetail detail = new MechanicDetail();
    detail.setMechanic(mechanicService.get(request.getMechanic()));
    detail.setIncluded(request.getIncluded());
    detail.setType(request.getType());
    detail.setCode(request.getCode());
    detail.setFactor(request.getFactor());
    detail.setDescription(request.getDescription());
    return detail;
  }

  @Override
  public List<MechanicDetail> list(Long mechanicId) {
    return repository.findAll(mechanicId);
  }

  @Override
  public MechanicDetail add(MechanicDetailRequest request) {
    MechanicDetail detail = init(request);
    validateRequest(request);
    return repository.save(detail);
  }

  private void validateRequest(MechanicDetailRequest request) {
    if (repository.findByMechanicAndTypeAndCode(request.getMechanic(),
          request.getType(), request.getCode()).isPresent()) {
      throw new BadRequestException("Item already added");
    }
  }
}
