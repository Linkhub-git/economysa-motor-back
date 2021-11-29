package com.economysa.motor.app.promotion.service.impl;

import com.economysa.motor.app.promotion.controller.request.MechanicDetailYRequest;
import com.economysa.motor.app.promotion.entity.MechanicDetailY;
import com.economysa.motor.app.promotion.repository.MechanicDetailYRepository;
import com.economysa.motor.app.promotion.service.MechanicDetailYService;
import com.economysa.motor.app.promotion.service.MechanicService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class MechanicDetailYServiceImpl implements MechanicDetailYService {

  @Autowired private MechanicDetailYRepository repository;
  @Autowired private MechanicService mechanicService;

  private MechanicDetailY init(MechanicDetailYRequest request) {
    MechanicDetailY detail = new MechanicDetailY();
    detail.setMechanic(mechanicService.get(request.getMechanic()));
    detail.setType(request.getType());
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
    return repository.save(detail);
  }
}
