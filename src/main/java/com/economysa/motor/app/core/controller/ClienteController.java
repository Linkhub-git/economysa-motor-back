package com.economysa.motor.app.core.controller;

import com.economysa.motor.app.core.entity.Cliente;
import com.economysa.motor.app.core.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/secured/cliente")
public class ClienteController {

	@Autowired private ClienteService service;

	@GetMapping
	public ResponseEntity<Page<Cliente>> list(Pageable pageable) {
		return new ResponseEntity(service.list(pageable), HttpStatus.OK);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Cliente> get(@PathVariable String codigo) {
		return new ResponseEntity(service.get(codigo), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente cliente) {
		return new ResponseEntity(service.create(cliente), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Cliente> update(@Valid @RequestBody Cliente cliente) {
		return new ResponseEntity(service.update(cliente), HttpStatus.OK);
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<String> delete(@PathVariable String codigo) {
		return new ResponseEntity(service.delete(codigo), HttpStatus.NO_CONTENT);
	}
}
