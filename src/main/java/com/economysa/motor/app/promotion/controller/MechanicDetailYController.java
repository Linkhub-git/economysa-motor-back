package com.economysa.motor.app.promotion.controller;

import com.economysa.motor.app.promotion.controller.request.MechanicDetailYRequest;
import com.economysa.motor.app.promotion.entity.MechanicDetailY;
import com.economysa.motor.app.promotion.service.MechanicDetailYService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/secured/mechanic_detail_y")
public class MechanicDetailYController {

  @Autowired private MechanicDetailYService service;

  @GetMapping
  public ResponseEntity<List<MechanicDetailY>> list(@RequestParam Long mechanicId) {
    return new ResponseEntity(service.list(mechanicId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<MechanicDetailY> add(@Valid @RequestBody MechanicDetailYRequest request) {
    return new ResponseEntity(service.add(request), HttpStatus.CREATED);
  }
}
