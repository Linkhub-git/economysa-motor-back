package com.economysa.motor.app.core.service.impl;

import com.economysa.motor.app.configuration.service.BrandService;
import com.economysa.motor.app.configuration.service.CategoryService;
import com.economysa.motor.app.configuration.service.UnityService;
import com.economysa.motor.app.core.controller.dto.ProductDto;
import com.economysa.motor.app.core.entity.Product;
import com.economysa.motor.app.core.repository.ProductRepository;
import com.economysa.motor.app.core.service.ProductService;
import com.economysa.motor.app.core.service.ProviderService;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import com.economysa.motor.util.ConstantMessage;
import com.economysa.motor.util.UtilCore;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

  @Autowired private ProductRepository repository;
  @Autowired private ProviderService providerService;
  @Autowired private CategoryService categoryService;
  @Autowired private BrandService brandService;
  @Autowired private UnityService unityService;

  @Override
  public Product init(ProductDto dto) {
    Product product = new Product();
    product.setCode(dto.getCode());
    product.setName(dto.getName());
    product.setCategory(categoryService.get(dto.getCategory()));
    product.setBrand(brandService.get(dto.getBrand()));
    log.info("Provider: " + dto.getProvider());
    product.setProvider(providerService.getByCode(dto.getProvider()));

    if (dto.getChatBot() == 1) {
      product.setChatBot(true);
    } else {
      product.setChatBot(false);
    }

    if (dto.getTomaPedido() == 1) {
      product.setTomaPedido(true);
    } else {
      product.setTomaPedido(false);
    }

    product.setUnitMaster(unityService.getByCode(dto.getUnitMaster()));
    product.setUnitMasterDescription(dto.getUnitMasterDescription());
    product.setUnitMasterEquivalent(dto.getUnitMasterEquivalent());
    product.setUnitMin(unityService.getByCode(dto.getUnitMin()));
    product.setUnitMinDescription(dto.getUnitMinDescription());
    product.setUnitMinEquivalent(dto.getUnitMinEquivalent());
    product.setCreationDate(UtilCore.UtilDate.fechaActual());

    return product;
  }

  @Override
  public void saveAll(List<Product> items) {
//    items.forEach(p -> repository.save(p));
    repository.saveAll(items);
  }

  @Override
  public Page<Product> list(Pageable pageable) {
    return repository.findAll(pageable);
  }

  @Override
  public List<Product> listByProvider(Long providerId) {
    return repository.findByProvider(providerId);
  }

  @Override
  public List<Product> search(String name) {
    return repository.find(name);
  }

  @Override
  public Product get(Long id) {
    Optional<Product> product = repository.findById(id);
    if (!product.isPresent()) {
      log.info("No Product entity for ID [ " + id + " ]");
      throw new ResourceNotFoundException(ConstantMessage.PRODUCT_NOT_FOUND);
    }
    return product.get();
  }
}
