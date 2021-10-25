package com.economysa.motor.app.promotion.service;

import com.economysa.motor.app.promotion.controller.request.MechanicTargetRequest;
import com.economysa.motor.app.promotion.entity.MechanicTarget;

import java.util.List;

public interface MechanicTargetService {

  List<MechanicTarget> list(Long mechanicId);
  MechanicTarget get(Long id);
  MechanicTarget create(MechanicTargetRequest request);
  MechanicTarget delete(Long targetId);
}
