package com.economysa.motor.app.promotion.service;

import com.economysa.motor.app.core.entity.Product;
import com.economysa.motor.app.promotion.controller.request.MechanicValidateRequest;
import com.economysa.motor.app.promotion.entity.MechanicProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MechanicProductService {

  Page<MechanicProduct> list(Long mechanicId, Pageable pageable);
  void addProductsForMechanic(Long mechanicId, String mechanicModality, Long targetId);
  void deleteProductsForMechanic(Long mechanicId, String mechanicModality);
  List<Product> validate(MechanicValidateRequest request);
}
