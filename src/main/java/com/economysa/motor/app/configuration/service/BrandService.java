package com.economysa.motor.app.configuration.service;

import com.economysa.motor.app.configuration.controller.dto.BrandDto;
import com.economysa.motor.app.configuration.entity.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BrandService {

  Brand save(BrandDto dto);
  Page<Brand> list(String name, Pageable pageable);
}
