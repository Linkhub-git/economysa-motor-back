package com.economysa.motor.app.core.controller;

import com.economysa.motor.app.core.entity.Proveedor;
import com.economysa.motor.app.core.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/secured/proveedor")
public class ProveedorController {

	@Autowired private ProveedorService service;

	@GetMapping
	public ResponseEntity<Page<Proveedor>> list(Pageable pageable) {
		return new ResponseEntity(service.list(pageable), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Proveedor> get(@PathVariable String id) {
		return new ResponseEntity(service.get(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Proveedor> create(@Valid @RequestBody Proveedor proveedor) {
		return new ResponseEntity(service.create(proveedor), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Proveedor> update(@Valid @RequestBody Proveedor proveedor) {
		return new ResponseEntity(service.update(proveedor), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable String id) {
		return new ResponseEntity(service.delete(id), HttpStatus.NO_CONTENT);
	}
}
