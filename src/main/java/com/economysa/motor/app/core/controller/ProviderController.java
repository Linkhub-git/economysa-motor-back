package com.economysa.motor.app.core.controller;

import com.economysa.motor.app.core.controller.request.ProviderRequest;
import com.economysa.motor.app.core.entity.Provider;
import com.economysa.motor.app.core.service.ProviderService;
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
@RequestMapping("/api/v1/secured/provider")
public class ProviderController {

	@Autowired private ProviderService service;

	@GetMapping
	public ResponseEntity<Page<Provider>> list(Pageable pageable) {
		return new ResponseEntity(service.list(pageable), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Provider> get(@PathVariable String id) {
		return new ResponseEntity(service.get(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Provider> create(@AuthenticationPrincipal UserDetails details,
																				 @Valid @RequestBody ProviderRequest request) {
		return new ResponseEntity(service.create(details.getUsername(), request), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Provider> update(@AuthenticationPrincipal UserDetails details,
																				 @PathVariable String id,
																				 @Valid @RequestBody ProviderRequest request) {
		return new ResponseEntity(service.update(details.getUsername(), id, request), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Provider> delete(@AuthenticationPrincipal UserDetails details,
																				 @PathVariable String id) {
		return new ResponseEntity(service.delete(details.getUsername(), id), HttpStatus.OK);
	}
}
