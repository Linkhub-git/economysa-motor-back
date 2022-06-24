package com.economysa.motor.app.core.controller;

import com.economysa.motor.app.core.entity.Provider;
import com.economysa.motor.app.core.service.ProviderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
		name = "Proveedores",
		description = "Endpoint donde se encuentran las operaciones respecto al recurso Proveedor."
)
@RestController
@RequestMapping("/api/v1/secured/provider")
public class ProviderController {

	@Autowired private ProviderService service;

	@Operation(
			description = "Listado paginado de Proveedores",
			summary = "Listado paginado de Proveedores",
			method = "GET"
	)
	@ApiResponses(
			{
					@ApiResponse(
							responseCode = "200",
							description = "Operación exitosa"
					),
					@ApiResponse(
							responseCode = "500",
							description = "Error interno del sistema"
					)
			}
	)
	@GetMapping
	public ResponseEntity<Page<Provider>> list(Pageable pageable) {
		return new ResponseEntity(service.list(pageable), HttpStatus.OK);
	}

	@Operation(
			description = "Listado de Proveedores",
			summary = "Listado de Proveedores",
			method = "GET"
	)
	@ApiResponses(
			{
					@ApiResponse(
							responseCode = "200",
							description = "Operación exitosa"
					),
					@ApiResponse(
							responseCode = "500",
							description = "Error interno del sistema"
					)
			}
	)
	@GetMapping("/all")
	public ResponseEntity<List<Provider>> list() {
		return new ResponseEntity<>(service.list(), HttpStatus.OK);
	}

	@Operation(
			description = "Listado de Proveedores",
			summary = "Listado de Proveedores",
			method = "GET"
	)
	@ApiResponses(
			{
					@ApiResponse(
							responseCode = "200",
							description = "Operación exitosa"
					),
					@ApiResponse(
							responseCode = "500",
							description = "Error interno del sistema"
					)
			}
	)
	@GetMapping("/search")
	public ResponseEntity<List<Provider>> search(@RequestParam String name) {
		return new ResponseEntity(service.search(name), HttpStatus.OK);
	}

	@Operation(
			description = "Obtiene Proveedor por ID",
			summary = "Obtiene Proveedor por ID",
			method = "GET"
	)
	@ApiResponses(
			{
					@ApiResponse(
							responseCode = "200",
							description = "Operación exitosa"
					),
					@ApiResponse(
							responseCode = "500",
							description = "Error interno del sistema"
					)
			}
	)
	@GetMapping("/{id}")
	public ResponseEntity<Provider> get(@PathVariable Long id) {
		return new ResponseEntity(service.get(id), HttpStatus.OK);
	}
}
