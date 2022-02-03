package com.economysa.motor.app.core.service;

import com.economysa.motor.app.core.controller.dto.ProductDto;
import com.economysa.motor.app.core.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

  Page<Product> list(Pageable pageable);
  List<Product> listByProvider(Long providerId);
  List<Product> search(String name);
  Product get(Long id);
  Product create(String creationUser, ProductDto request);
  Product update(String updateUser, Long id, ProductDto request);
  Product delete(String updateUser, Long id);
}
