package com.economysa.motor.app.promotion.service;

import com.economysa.motor.app.promotion.controller.request.MechanicRequest;
import com.economysa.motor.app.promotion.entity.Mechanic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MechanicService {

  Page<Mechanic> list(String emitter, Pageable pageable);
  Mechanic get(Long id);
  Mechanic create(String creationUser, MechanicRequest request);
  Mechanic update(Long id, String updateUser, MechanicRequest request);
  Mechanic delete(String updateUser, Long id);
  List<Mechanic> findActive();
}
