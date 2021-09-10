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

	@GetMapping("/{id}")
	public ResponseEntity<Vendedor> get(@PathVariable String id) {
		return new ResponseEntity(service.get(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Vendedor> create(@Valid @RequestBody Vendedor vendedor) {
		return new ResponseEntity(service.create(vendedor), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Vendedor> update(@Valid @RequestBody Vendedor vendedor) {
		return new ResponseEntity(service.update(vendedor), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable String id) {
		return new ResponseEntity(service.delete(id), HttpStatus.NO_CONTENT);
	}
}
