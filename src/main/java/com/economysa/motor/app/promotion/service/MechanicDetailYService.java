package com.economysa.motor.app.promotion.service;

import com.economysa.motor.app.promotion.controller.request.MechanicDetailYRequest;
import com.economysa.motor.app.promotion.entity.MechanicDetailY;

import java.util.List;

public interface MechanicDetailYService {

  List<MechanicDetailY> list(Long mechanicId);
  MechanicDetailY add(MechanicDetailYRequest request);
}
