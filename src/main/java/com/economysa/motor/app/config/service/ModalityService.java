package com.economysa.motor.app.config.service;

import com.economysa.motor.app.config.entity.Modality;

import java.util.List;

public interface ModalityService {

  List<Modality> list();
  Modality get(Long id);
}
