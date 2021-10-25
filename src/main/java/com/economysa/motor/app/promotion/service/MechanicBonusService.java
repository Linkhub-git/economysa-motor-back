package com.economysa.motor.app.promotion.service;

import com.economysa.motor.app.core.entity.Product;
import com.economysa.motor.app.promotion.controller.request.MechanicBonusRequest;
import com.economysa.motor.app.promotion.controller.request.MechanicValidateRequest;
import com.economysa.motor.app.promotion.entity.MechanicBonus;

import java.util.List;

public interface MechanicBonusService {

  List<MechanicBonus> list(Long mechanicId);
  MechanicBonus get(Long id);
  MechanicBonus create(String creationUser, MechanicBonusRequest request);
  MechanicBonus update(String updateUser, Long id, MechanicBonusRequest request);
  MechanicBonus delete(String updateUser, Long id);
}
