package com.economysa.motor.app.promotion.service;

import com.economysa.motor.app.promotion.controller.request.MechanicBonusRequest;
import com.economysa.motor.app.promotion.entity.MechanicBonus;

import java.util.List;

public interface MechanicBonusService {

  List<MechanicBonus> list(Long mechanicId);
  MechanicBonus add(MechanicBonusRequest request);
}
