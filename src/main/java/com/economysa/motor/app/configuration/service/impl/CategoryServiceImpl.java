package com.economysa.motor.app.configuration.service.impl;

import com.economysa.motor.app.configuration.controller.dto.CategoryDto;
import com.economysa.motor.app.configuration.entity.Category;
import com.economysa.motor.app.configuration.repository.CategoryRepository;
import com.economysa.motor.app.configuration.service.CategoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class CategoryServiceImpl implements CategoryService {

  @Autowired private CategoryRepository repository;

  private Category initChild(Category parent, String name) {
    Category category = new Category();
    category.setParent(parent);
    category.setName(name);
    return category;
  }

  private Category initParent(String name) {
    Category category = new Category();
    category.setName(name);
    return category;
  }

  @Override
  public Page<Category> list(String name, Pageable pageable) {
    if (name.equals("")) {
      return repository.find(pageable);
    } else {
      return repository.findByParentOrName(name, pageable);
    }
  }

  @Override
  public Category get(String name) {
    return repository.findByNameAndParentNotNull(name).get(0);
  }

  @Override
  public Category save(CategoryDto dto) {
    List<Category> items = repository.findParent(dto.getParent());
    Category parent = null;
    if (items.isEmpty()) {
      parent = repository.save(initParent(dto.getParent()));
    } else {
      parent = items.get(0);
    }

    Category child = repository.findChildByName(parent.getId(), dto.getName());
    if (child == null) {
      child = repository.save(initChild(parent, dto.getName()));
    }

    return child;
  }
}
