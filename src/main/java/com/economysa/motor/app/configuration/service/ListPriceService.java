package com.economysa.motor.app.configuration.service;

import com.economysa.motor.app.configuration.entity.ListPrice;

import java.util.List;

public interface ListPriceService {

  List<ListPrice> list();
  ListPrice get(Long id);
}
