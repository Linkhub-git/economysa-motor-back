package com.economysa.motor.app.core.controller;

import com.economysa.motor.app.core.entity.Promocion;
import com.economysa.motor.app.core.service.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/secured/promocion")
public class PromocionController {

	@Autowired private PromocionService service;

	@GetMapping
	public ResponseEntity<Page<Promocion>> list(Pageable pageable) {
		return new ResponseEntity(service.list(pageable), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Promocion> get(@PathVariable String id) {
		return new ResponseEntity(service.get(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Promocion> create(@Valid @RequestBody Promocion promocion) {
		return new ResponseEntity(service.create(promocion), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Promocion> update(@Valid @RequestBody Promocion promocion) {
		return new ResponseEntity(service.update(promocion), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable String id) {
		return new ResponseEntity(service.delete(id), HttpStatus.NO_CONTENT);
	}
}
