package com.economysa.motor.app.promotion.controller;

import com.economysa.motor.app.promotion.controller.request.MechanicTargetRequest;
import com.economysa.motor.app.promotion.entity.MechanicTarget;
import com.economysa.motor.app.promotion.service.MechanicTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/secured/mechanic_target")
public class MechanicTargetController {

  @Autowired private MechanicTargetService service;

  @GetMapping
  public ResponseEntity<List<MechanicTarget>> list(@RequestParam Long mechanicId) {
    return new ResponseEntity(service.list(mechanicId), HttpStatus.OK);
  }

  @GetMapping("{/targetId}")
  public ResponseEntity<MechanicTarget> get(@PathVariable Long targetId) {
    return new ResponseEntity(service.get(targetId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<MechanicTarget> create(@Valid @RequestBody MechanicTargetRequest request) {
    return new ResponseEntity(service.create(request), HttpStatus.CREATED);
  }

  @DeleteMapping("/{targetId}")
  public ResponseEntity<MechanicTarget> delete(@PathVariable Long targetId) {
    return new ResponseEntity(service.delete(targetId), HttpStatus.OK);
  }
}
