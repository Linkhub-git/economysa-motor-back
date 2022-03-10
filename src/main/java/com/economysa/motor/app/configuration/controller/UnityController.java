package com.economysa.motor.app.configuration.controller;

import com.economysa.motor.app.configuration.entity.Unity;
import com.economysa.motor.app.configuration.service.UnityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
			name = "Unidades",
			description = "Endpoint donde se encuentran las operaciones respecto al recurso Unidad."
)
@RestController
@RequestMapping("/api/v1/secured/unity")
@AllArgsConstructor
public class UnityController {

	private final UnityService service;

	@Operation(
				description = "Listado paginado de Unidades",
				summary = "Listado paginado de Unidades",
				method = "GET"
	)
	@ApiResponses(
				@ApiResponse(
							responseCode = "200",
							description = "Operación exitosa"
				)
	)
	@GetMapping
	public ResponseEntity<Page<Unity>> list(
				@Parameter(name = "pageable", description = "Información de paginación. Normalmente se envía page y size.")
							Pageable pageable) {
		return new ResponseEntity<>(service.list(pageable), HttpStatus.OK);
	}

	@Operation(
				description = "Obtiene un recurso Unidad por su ID",
				summary = "Obtiene un recurso Unidad por su ID",
				method = "GET"
	)
	@ApiResponses(
				{
							@ApiResponse(
							responseCode = "200",
							description = "Operación exitosa"
							),
							@ApiResponse(
										responseCode = "404",
										description = "El recurso no fue encontrado"
							)
				}
	)
	@GetMapping("/id")
	public ResponseEntity<Unity> get(
				@Parameter(name = "id", description = "ID del recurso a buscar", required = true)
				@PathVariable Long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}
}
