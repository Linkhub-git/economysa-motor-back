package com.economysa.motor.app.core.controller;

import com.economysa.motor.app.core.entity.DireccionEntrega;
import com.economysa.motor.app.core.service.DireccionEntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/secured/direccion_entrega")
public class DireccionEntregaController {

	@Autowired private DireccionEntregaService service;

	@GetMapping
	public ResponseEntity<Page<DireccionEntrega>> list(Pageable pageable) {
		return new ResponseEntity(service.list(pageable), HttpStatus.OK);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<DireccionEntrega> get(@PathVariable String codigo) {
		return new ResponseEntity(service.get(codigo), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<DireccionEntrega> create(@Valid @RequestBody DireccionEntrega direccionEntrega) {
		return new ResponseEntity(service.create(direccionEntrega), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<DireccionEntrega> update(@Valid @RequestBody DireccionEntrega direccionEntrega) {
		return new ResponseEntity(service.update(direccionEntrega), HttpStatus.OK);
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<String> delete(@PathVariable String codigo) {
		return new ResponseEntity(service.delete(codigo), HttpStatus.NO_CONTENT);
	}
}
