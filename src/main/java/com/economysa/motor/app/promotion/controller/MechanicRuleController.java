package com.economysa.motor.app.promotion.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.economysa.motor.app.promotion.controller.request.MechanicRulesRequest;
import com.economysa.motor.app.promotion.controller.response.MechanicRuleResponse;
import com.economysa.motor.app.promotion.controller.response.MechanicRulesResponse;
import com.economysa.motor.app.promotion.service.MechanicRuleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "", description = "Endpoint donde se encuentran las operaciones respecto al recurso Detalle de Mecánica.")
@RestController
@RequestMapping("/api/v1/secured/mechanic_rules")
public class MechanicRuleController {

	@Autowired
	private MechanicRuleService service;

	@Operation(description = "Listado de reglas por mecanica", summary = "Listado de reglas por mecanica", method = "GET")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Operación exitosa"),
			@ApiResponse(responseCode = "500", description = "Error interno del sistema") })
	@GetMapping
	public ResponseEntity<MechanicRulesResponse> list(@RequestParam Long mechanicId) {
		return new ResponseEntity(service.list(mechanicId), HttpStatus.OK);
	}

	@Operation(description = "Obtiene una Regla por ID", summary = "Obtiene una Regla por ID", method = "GET")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Operación exitosa"),
			@ApiResponse(responseCode = "404", description = "No se encontro el recurso"),
			@ApiResponse(responseCode = "500", description = "Error interno del sistema") })
	@GetMapping("/{id}")
	public ResponseEntity<MechanicRuleResponse> get(@PathVariable Long id) {
		return new ResponseEntity(service.get(id), HttpStatus.OK);
	}

	@Operation(description = "Agrega reglas a la Mecánica", summary = "Agrega reglas a la Mecánica", method = "POST")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "Operación exitosa"),
			@ApiResponse(responseCode = "500", description = "Error interno del sistema") })
	@PostMapping
	public ResponseEntity<MechanicRulesResponse> add(@Valid @RequestBody MechanicRulesRequest request) {
		return new ResponseEntity(service.addRules(request), HttpStatus.CREATED);
	}
}
