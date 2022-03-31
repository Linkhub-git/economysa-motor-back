package com.economysa.motor.app.configuration.service;

import com.economysa.motor.app.configuration.controller.dto.CategoryDto;
import com.economysa.motor.app.configuration.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

  Category save(CategoryDto dto);
  Page<Category> list(String name, Pageable pageable);
  List<Category> listParent();
  List<Category> listByParent(Long parentId);
  Category get(String name);
  Category get(Long id);
}
