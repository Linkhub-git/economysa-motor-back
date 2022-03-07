package com.economysa.motor.app.core.service;

import com.economysa.motor.app.core.controller.dto.ProductDto;
import com.economysa.motor.app.core.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

  Product init(ProductDto dto);
  void saveAll(List<Product> items);
  Page<Product> list(Pageable pageable);
  List<Product> listByProvider(Long providerId);
  List<Product> search(String name);
  Product get(Long id);
}
