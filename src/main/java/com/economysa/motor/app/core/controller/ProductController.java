package com.economysa.motor.app.core.controller;

import com.economysa.motor.app.core.entity.Product;
import com.economysa.motor.app.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/secured/product")
public class ProductController {

  @Autowired private ProductService service;

  @GetMapping
  public ResponseEntity<Page<Product>> list(Pageable pageable) {
    return new ResponseEntity(service.list(pageable), HttpStatus.OK);
  }

  @GetMapping("/search")
  public ResponseEntity<List<Product>> search(@RequestParam String name) {
    return new ResponseEntity(service.search(name), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> get(@PathVariable Long id) {
    return new ResponseEntity(service.get(id), HttpStatus.OK);
  }
}
