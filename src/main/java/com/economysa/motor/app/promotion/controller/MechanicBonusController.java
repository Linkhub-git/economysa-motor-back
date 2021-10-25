package com.economysa.motor.app.promotion.controller;

import com.economysa.motor.app.promotion.controller.request.MechanicBonusRequest;
import com.economysa.motor.app.promotion.entity.MechanicBonus;
import com.economysa.motor.app.promotion.service.MechanicBonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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

  @GetMapping("/{id}")
  public ResponseEntity<MechanicBonus> get(@PathVariable Long id) {
    return new ResponseEntity(service.get(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<MechanicBonus> create(@AuthenticationPrincipal UserDetails details,
                                              @Valid @RequestBody MechanicBonusRequest request) {
    return new ResponseEntity(service.create(details.getUsername(), request), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<MechanicBonus> update(@AuthenticationPrincipal UserDetails details,
                                              @PathVariable Long id,
                                              @Valid @RequestBody MechanicBonusRequest request) {
    return new ResponseEntity(service.update(details.getUsername(), id, request), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<MechanicBonus> delete(@AuthenticationPrincipal UserDetails details,
                                              @PathVariable Long id) {
    return new ResponseEntity(service.delete(details.getUsername(), id), HttpStatus.OK);
  }
}
