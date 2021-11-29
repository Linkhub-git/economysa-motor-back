package com.economysa.motor.app.promotion.controller;

import com.economysa.motor.app.promotion.controller.request.MechanicBonusRequest;
import com.economysa.motor.app.promotion.entity.MechanicBonus;
import com.economysa.motor.app.promotion.service.MechanicBonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/secured/mechanic_bonus")
public class MechanicBonusController {

  @Autowired private MechanicBonusService service;

  @GetMapping
  public ResponseEntity<List<MechanicBonus>> list(@RequestParam Long mechanicId) {
    return new ResponseEntity(service.list(mechanicId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<MechanicBonus> add(@Valid @RequestBody MechanicBonusRequest request) {
    return new ResponseEntity(service.add(request), HttpStatus.CREATED);
  }
}
