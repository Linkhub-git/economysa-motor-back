package com.economysa.motor.app.promotion.controller;

import com.economysa.motor.app.promotion.controller.request.MechanicEntryRequest;
import com.economysa.motor.app.promotion.entity.MechanicEntry;
import com.economysa.motor.app.promotion.service.MechanicEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/secured/mechanic_entry")
public class MechanicEntryController {

  @Autowired
  private MechanicEntryService service;

  @GetMapping
  public ResponseEntity<List<MechanicEntry>> list(@RequestParam Long mechanic) {
    return new ResponseEntity<>(service.listByMechanic(mechanic), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<MechanicEntry> add(@Valid @RequestBody MechanicEntryRequest request) {
    return new ResponseEntity<>(service.add(request), HttpStatus.OK);
  }
}
