package com.economysa.motor.app.promotion.controller;

import com.economysa.motor.app.core.entity.Product;
import com.economysa.motor.app.promotion.controller.request.MechanicValidateRequest;
import com.economysa.motor.app.promotion.service.MechanicProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/secured/mechanic_product")
public class MechanicProductController {

  @Autowired private MechanicProductService service;

  @PostMapping("/{validate}")
  public ResponseEntity<List<Product>> validate(@Valid @RequestBody MechanicValidateRequest request) {
    return new ResponseEntity(service.validate(request), HttpStatus.OK);
  }
}
