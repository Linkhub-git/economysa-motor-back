package com.economysa.motor.app.promotion.controller;

import com.economysa.motor.app.promotion.controller.request.MechanicRequest;
import com.economysa.motor.app.promotion.entity.Mechanic;
import com.economysa.motor.app.promotion.service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/secured/mechanic")
public class MechanicController {

  @Autowired private MechanicService service;

  @GetMapping
  public ResponseEntity<Page<Mechanic>> list(Pageable pageable) {
    return new ResponseEntity(service.list(pageable), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Mechanic> get(@PathVariable Long id) {
    return new ResponseEntity(service.get(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Mechanic> create(@AuthenticationPrincipal UserDetails details,
                                         @Valid @RequestBody MechanicRequest request) {
    return new ResponseEntity(service.create(details.getUsername(), request), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Mechanic> update(@AuthenticationPrincipal UserDetails details,
                                         @PathVariable Long id,
                                         @Valid @RequestBody MechanicRequest request) {
    return new ResponseEntity(service.update(id, details.getUsername(), request), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Mechanic> delete(@AuthenticationPrincipal UserDetails details,
                                         @PathVariable Long id) {
    return new ResponseEntity(service.delete(details.getUsername(), id), HttpStatus.OK);
  }
}
