package com.economysa.motor.app.promotion.service;

import com.economysa.motor.app.promotion.controller.request.MechanicEntryRequest;
import com.economysa.motor.app.promotion.entity.MechanicEntry;

import java.util.List;

public interface MechanicEntryService {

  List<MechanicEntry> listByMechanic(Long idMechanic);
  MechanicEntry add(MechanicEntryRequest request);
}
