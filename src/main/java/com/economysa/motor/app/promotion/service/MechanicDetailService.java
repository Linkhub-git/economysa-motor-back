package com.economysa.motor.app.promotion.service;

import com.economysa.motor.app.promotion.controller.request.MechanicDetailRequest;
import com.economysa.motor.app.promotion.entity.MechanicDetail;

import java.util.List;

public interface MechanicDetailService {

  List<MechanicDetail> list(Long mechanicId);
  MechanicDetail add(MechanicDetailRequest request);
}
