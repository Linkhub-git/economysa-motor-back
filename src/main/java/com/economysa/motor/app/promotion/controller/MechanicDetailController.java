package com.economysa.motor.app.promotion.controller;

import com.economysa.motor.app.promotion.controller.request.MechanicDetailRequest;
import com.economysa.motor.app.promotion.entity.MechanicDetail;
import com.economysa.motor.app.promotion.service.MechanicDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/secured/mechanic_detail")
public class MechanicDetailController {

  @Autowired private MechanicDetailService service;

  @GetMapping
  public ResponseEntity<List<MechanicDetail>> list(@RequestParam Long mechanic) {
    return new ResponseEntity(service.list(mechanic), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<MechanicDetail> add(@Valid @RequestBody MechanicDetailRequest request) {
    return new ResponseEntity(service.add(request), HttpStatus.CREATED);
  }
}
