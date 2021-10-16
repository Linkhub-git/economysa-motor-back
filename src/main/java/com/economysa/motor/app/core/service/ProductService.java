package com.economysa.motor.app.core.service;

import com.economysa.motor.app.core.controller.request.ProductRequest;
import com.economysa.motor.app.core.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

  Page<Product> list(Pageable pageable);
  Product get(Long id);
  Product create(String creationUser, ProductRequest request);
  Product update(String updateUser, Long id, ProductRequest request);
  Product delete(String updateUser, Long id);
}
