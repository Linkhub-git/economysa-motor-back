package com.economysa.motor.app.core.service;

import com.economysa.motor.app.core.controller.dto.ProductDto;
import com.economysa.motor.app.core.controller.request.SearchRequest;
import com.economysa.motor.app.core.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

  Product init(ProductDto dto);
  void saveAll(List<Product> items);
  
  Page<Product> list(Pageable pageable);
  List<Product> findByConditions(SearchRequest req);
  
  Product get(Long id);
  Product listByProductCode(String id);
  List<Product> listByProductName(String id);
  List<Product> listByProviderId(Long providerId);
  List<Product> listByProviderCode(String providerCode);
  List<Product> listByProviderName(String providerName);
  List<Product> listByBrandId(Long brandId);
  List<Product> listByBrandName(String brandName);
  List<Product> listByCategoryId(Long categoryId);
  List<Product> listByCategoryName(String categoryName);
}
