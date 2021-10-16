package com.economysa.motor.app.core.service.impl;

import com.economysa.motor.app.core.controller.request.ProductRequest;
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
import java.util.Optional;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

  @Autowired private ProductRepository repository;
  @Autowired private ProviderService providerService;

  private Product init() {
    Product product = new Product();
    product.setMasterStockAmount(BigDecimal.ZERO);
    product.setSalesPackaging(BigDecimal.ZERO);
    product.setStockAmount(BigDecimal.ZERO);
    product.setStock(BigDecimal.ZERO);
    product.setBasePrice(BigDecimal.ZERO);
    product.setMargin(BigDecimal.ZERO);
    product.setFinalPrice(BigDecimal.ZERO);
    product.setCreationDate(UtilCore.UtilDate.fechaActual());
    product.setStatus(Boolean.TRUE);
    return product;
  }

  private Product init(String creationUser, ProductRequest request) {
    Product product = init();
    product = setData(product, request);
    product.setCreationUser(creationUser);
    return product;
  }

  private Product setData(Product product, ProductRequest request) {
    product.setProvider(providerService.get(request.getProvider()));
    product.setName(request.getName());
    product.setPurchasePackaging(request.getPurchasePackaging());
    product.setMasterStockAmount(request.getMasterStockAmount());
    product.setSalesPackaging(request.getSalesPackaging());
    product.setStockAmount(request.getStockAmount());
    product.setStock(request.getStock());
    product.setBasePrice(request.getBasePrice());
    product.setMargin(request.getMargin());
    product.setFinalPrice(calculateFinalPrice());
    return product;
  }

  @Override
  public Page<Product> list(Pageable pageable) {
    return repository.findAll(pageable);
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

  @Override
  public Product create(String creationUser, ProductRequest request) {
    Product product = init(creationUser, request);

    return repository.save(product);
  }

  @Override
  public Product update(String updateUser, Long id, ProductRequest request) {
    Product product = get(id);
    product = setData(product, request);
    product.setUpdateUser(updateUser);
    product.setUpdateDate(UtilCore.UtilDate.fechaActual());

    return repository.save(product);
  }

  @Override
  public Product delete(String updateUser, Long id) {
    Product product = get(id);
    product.setStatus(Boolean.FALSE);
    product.setUpdateUser(updateUser);
    product.setUpdateDate(UtilCore.UtilDate.fechaActual());

    return repository.save(product);
  }

  private BigDecimal calculateFinalPrice() {
    // TODO: 16/10/21 Consultar como calcular el precio final
    return BigDecimal.ONE;
  }
}
