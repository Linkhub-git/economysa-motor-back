package com.economysa.motor.app.core.controller;

import com.economysa.motor.app.core.entity.Producto;
import com.economysa.motor.app.core.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/secured/producto")
public class ProductoController {

	@Autowired private ProductoService service;

	@GetMapping
	public ResponseEntity<Page<Producto>> list(Pageable pageable) {
		return new ResponseEntity(service.list(pageable), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Producto> get(@PathVariable String id) {
		return new ResponseEntity(service.get(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Producto> create(@Valid @RequestBody Producto producto) {
		return new ResponseEntity(service.create(producto), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Producto> update(@Valid @RequestBody Producto producto) {
		return new ResponseEntity(service.update(producto), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable String id) {
		return new ResponseEntity(service.delete(id), HttpStatus.NO_CONTENT);
	}
}
