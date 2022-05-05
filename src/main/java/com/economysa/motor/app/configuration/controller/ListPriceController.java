package com.economysa.motor.app.configuration.controller;

import com.economysa.motor.app.configuration.entity.ListPrice;
import com.economysa.motor.app.configuration.service.ListPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/secured/list_price")
public class ListPriceController {

  @Autowired private ListPriceService service;

  @GetMapping
  public ResponseEntity<List<ListPrice>> list() {
    return new ResponseEntity<>(service.list(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ListPrice> get(@PathVariable Long id) {
    return new ResponseEntity<>(service.get(id), HttpStatus.OK);
  }
}
