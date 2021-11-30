package com.economysa.motor.app.core.controller;

import com.economysa.motor.app.core.entity.Vendedor;
import com.economysa.motor.app.core.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/secured/vendedor")
public class VendedorController {

	@Autowired private VendedorService service;

	@GetMapping
	public ResponseEntity<Page<Vendedor>> list(Pageable pageable) {
		return new ResponseEntity(service.list(pageable), HttpStatus.OK);
	}

	@GetMapping("/{code}")
	public ResponseEntity<Vendedor> get(@PathVariable String code) {
		return new ResponseEntity(service.get(code), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Vendedor> create(@Valid @RequestBody Vendedor vendedor) {
		return new ResponseEntity(service.create(vendedor), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Vendedor> update(@Valid @RequestBody Vendedor vendedor) {
		return new ResponseEntity(service.update(vendedor), HttpStatus.OK);
	}

	@DeleteMapping("/{code}")
	public ResponseEntity<String> delete(@PathVariable String code) {
		return new ResponseEntity(service.delete(code), HttpStatus.NO_CONTENT);
	}
}
