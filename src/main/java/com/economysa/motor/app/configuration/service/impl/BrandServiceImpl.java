package com.economysa.motor.app.configuration.service.impl;

import com.economysa.motor.app.configuration.controller.dto.BrandDto;
import com.economysa.motor.app.configuration.entity.Brand;
import com.economysa.motor.app.configuration.repository.BrandRepository;
import com.economysa.motor.app.configuration.service.BrandService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class BrandServiceImpl implements BrandService {

  @Autowired private BrandRepository repository;

  private Brand initParent(String name) {
    Brand brand = new Brand();
    brand.setName(name);
    return brand;
  }

  private Brand initChild(Brand parent, String name) {
    Brand brand = new Brand();
    brand.setParent(parent);
    brand.setName(name);
    return brand;
  }

  @Override
  public Brand save(BrandDto dto) {
    List<Brand> items = repository.findParent(dto.getParent());
    Brand parent = null;
    if (items.isEmpty()) {
      parent = repository.save(initParent(dto.getParent()));
    } else {
      parent = items.get(0);
    }

    Brand child = repository.findChildByName(parent.getId(), dto.getName());
    if (child == null) {
      child = repository.save(initChild(parent, dto.getName()));
    }

    return child;
  }

  @Override
  public Page<Brand> list(String name, Pageable pageable) {
    if (name.equals("")) {
      return repository.find(pageable);
    }
    return repository.findByParentOrName(name, pageable);
  }
}
