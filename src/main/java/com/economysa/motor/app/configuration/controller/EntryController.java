package com.economysa.motor.app.configuration.controller;

import com.economysa.motor.app.configuration.entity.Entry;
import com.economysa.motor.app.configuration.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/secured/entry")
public class EntryController {

  @Autowired
  private EntryService service;

  @GetMapping
  public ResponseEntity<List<Entry>> list(@RequestParam Long listPrice) {
    return new ResponseEntity<>(service.listByListPrice(listPrice), HttpStatus.OK);
  }

  @GetMapping("/search")
  public ResponseEntity<List<Entry>> search(@RequestParam String query) {
    return new ResponseEntity<>(service.search(query), HttpStatus.OK);
  }
}
