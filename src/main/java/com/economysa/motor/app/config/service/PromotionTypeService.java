package com.economysa.motor.app.config.service;

import com.economysa.motor.app.config.entity.PromotionType;

import java.util.List;

public interface PromotionTypeService {

  List<PromotionType> list();
  PromotionType get(Long id);
}
