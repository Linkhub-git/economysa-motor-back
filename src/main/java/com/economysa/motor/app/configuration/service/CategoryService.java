package com.economysa.motor.app.configuration.service;

import com.economysa.motor.app.configuration.controller.dto.CategoryDto;
import com.economysa.motor.app.configuration.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

  Category save(CategoryDto dto);
  Page<Category> list(String name, Pageable pageable);
  Category get(String name);
}
