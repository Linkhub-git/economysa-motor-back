package com.economysa.motor.app.configuration.controller;

import com.economysa.motor.app.configuration.entity.Unity;
import com.economysa.motor.app.configuration.service.UnityService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/secured/unity")
@AllArgsConstructor
public class UnityController {

	private final UnityService service;

	@GetMapping
	public ResponseEntity<Page<Unity>> list(Pageable pageable) {
		return new ResponseEntity<>(service.list(pageable), HttpStatus.OK);
	}

	@GetMapping("/id")
	public ResponseEntity<Unity> get(@PathVariable Long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}
}
