package com.economysa.motor.app.promotion.service.impl;

import com.economysa.motor.app.core.entity.Product;
import com.economysa.motor.app.core.service.ProductService;
import com.economysa.motor.app.promotion.controller.request.MechanicValidateRequest;
import com.economysa.motor.app.promotion.entity.MechanicBonus;
import com.economysa.motor.app.promotion.entity.MechanicProduct;
import com.economysa.motor.app.promotion.repository.MechanicProductRepository;
import com.economysa.motor.app.promotion.service.MechanicProductService;
import com.economysa.motor.util.ConstantMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class MechanicProductServiceImpl implements MechanicProductService {

  @Autowired private MechanicProductRepository repository;
  @Autowired private ProductService productService;

  private MechanicProduct init(Long mechanicId, Product product) {
    MechanicProduct mechanicProduct = new MechanicProduct();
    mechanicProduct.setMechanic(mechanicId);
    mechanicProduct.setProduct(product);
    return mechanicProduct;
  }

  @Override
  public Page<MechanicProduct> list(Long mechanicId, Pageable pageable) {
    return repository.findByMechanic(mechanicId, pageable);
  }

  @Override
  public void addProductsForMechanic(Long mechanicId, String mechanicModality, Long targetId) {
    if (mechanicModality.equals(ConstantMessage.MECHANIC_MODALITY_PROVIDER)) {
      addProducts(mechanicId, productService.listByProvider(targetId));
    }
  }

  @Override
  public void deleteProductsForMechanic(Long mechanicId, String mechanicModality) {
    if (mechanicModality.equals(ConstantMessage.MECHANIC_MODALITY_PROVIDER)) {
      repository.deleteAll(repository.findByMechanic(mechanicId));
    }
  }

  @Override
  public List<Product> validate(MechanicValidateRequest request) {
    List<Product> result = new ArrayList<>();
    request.getItems().forEach(productId -> {
      Optional<MechanicProduct> product = repository.find(request.getMechanic(), productId);
      if (product.isPresent()) {
        result.add(product.get().getProduct());
      }
    });

    return result;
  }

  private void addProducts(Long mechanicId, List<Product> products) {
    if (products != null && !products.isEmpty()) {
      products.forEach(p -> {
        repository.save(init(mechanicId, p));
      });
    }
  }
}
