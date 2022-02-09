package com.economysa.motor.app.configuration.controller;

import com.economysa.motor.app.configuration.entity.Category;
import com.economysa.motor.app.configuration.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/secured/category")
public class CategoryController {

  @Autowired private CategoryService service;

  @GetMapping
  public ResponseEntity<Page<Category>> list(
        @RequestParam(required = false, defaultValue = "") String name,
        Pageable pageable) {
    return new ResponseEntity<>(service.list(name, pageable), HttpStatus.OK);
  }
}
