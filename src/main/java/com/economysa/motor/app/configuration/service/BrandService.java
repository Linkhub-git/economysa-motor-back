package com.economysa.motor.app.configuration.service;

import com.economysa.motor.app.configuration.controller.dto.BrandDto;
import com.economysa.motor.app.configuration.entity.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BrandService {

  Brand save(BrandDto dto);
  Page<Brand> list(String name, Pageable pageable);
  List<Brand> listParent();
  List<Brand> listByParent(Long parentId);
  Brand get(String name);
  Brand get(Long id);
}
