package com.economysa.motor.app.core.controller;

import com.economysa.motor.app.core.controller.request.ProviderRequest;
import com.economysa.motor.app.core.entity.Provider;
import com.economysa.motor.app.core.service.ProviderService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/secured/provider")
@Api(tags = "Proveedores")
public class ProviderController {

	@Autowired private ProviderService service;

	@ApiOperation(
			value = "Listado de Proveedores paginado",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			response = Page.class,
			httpMethod = "GET"
	)
	@ApiResponses({
			@ApiResponse(
					code = 200,
					message = "Listado paginado de Proveedores",
					response = Page.class
			),
			@ApiResponse(
					code = 401,
					message = "No está autorizado para realizar esta consulta"
			)
	})
	@GetMapping
	public ResponseEntity<Page<Provider>> list(Pageable pageable) {
		return new ResponseEntity(service.list(pageable), HttpStatus.OK);
	}

	@ApiOperation(
			value = "Obtiene un Proveedor por su Identificador",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			response = Provider.class,
			httpMethod = "GET"
	)
	@ApiResponses({
			@ApiResponse(
					code = 200,
					message = "Obtiene un Proveedor por su Identificador",
					response = Provider.class
			),
			@ApiResponse(
					code = 401,
					message = "No está autorizado para realizar esta consulta"
			),
			@ApiResponse(
					code = 404,
					message = "El recurso solicitado no existe"
			)
	})
	@GetMapping("/{id}")
	public ResponseEntity<Provider> get(@ApiParam(value = "Identificador del Proveedor", required = true)
																			@PathVariable Long id) {
		return new ResponseEntity(service.get(id), HttpStatus.OK);
	}

	@ApiOperation(
			value = "Registra la información de un Proveedor en el sistema",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			response = Provider.class,
			httpMethod = "POST"
	)
	@ApiResponses({
			@ApiResponse(
					code = 201,
					message = "El Proveedor ha sido registrado correctamente",
					response = Provider.class
			),
			@ApiResponse(
					code = 401,
					message = "No está autorizado para realizar esta operación"
			),
			@ApiResponse(
					code = 404,
					message = "El recurso solicitado no existe"
			),
			@ApiResponse(
					code = 409,
					message = "El identificador ingresado ya existe en el sistema"
			)
	})
	@PostMapping
	public ResponseEntity<Provider> create(@AuthenticationPrincipal UserDetails details,
																				 @ApiParam(value = "Cuerpo de la petición", required = true)
																				 @Valid @RequestBody ProviderRequest request) {
		return new ResponseEntity(service.create(details.getUsername(), request), HttpStatus.CREATED);
	}

	@ApiOperation(
			value = "Actualiza la información de un Proveedor en el sistema",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			response = Provider.class,
			httpMethod = "PUT"
	)
	@ApiResponses({
			@ApiResponse(
					code = 200,
					message = "La información ha sido actualizada correctamente",
					response = Provider.class
			),
			@ApiResponse(
					code = 401,
					message = "No está autorizado para realizar esta operación"
			),
			@ApiResponse(
					code = 404,
					message = "El recurso solicitado no existe"
			)
	})
	@PutMapping("/{id}")
	public ResponseEntity<Provider> update(@AuthenticationPrincipal UserDetails details,
																				 @ApiParam(value = "Identificador del Proveedor", required = true)
																				 @PathVariable Long id,
																				 @ApiParam(value = "Cuerpo de la petición", required = true)
																				 @Valid @RequestBody ProviderRequest request) {
		return new ResponseEntity(service.update(details.getUsername(), id, request), HttpStatus.OK);
	}

	@ApiOperation(
			value = "Elimina de forma permanente un Proveedor en el sistema",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			response = Provider.class,
			httpMethod = "DELETE"
	)
	@ApiResponses({
			@ApiResponse(
					code = 200,
					message = "El Proveedor ha sido eliminado correctamente",
					response = Provider.class
			),
			@ApiResponse(
					code = 401,
					message = "No está autorizado para realizar esta operación"
			),
			@ApiResponse(
					code = 404,
					message = "El recurso solicitado no existe"
			)
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<Provider> delete(@AuthenticationPrincipal UserDetails details,
																				 @ApiParam(value = "Identificador del Proveedor", required = true)
																				 @PathVariable Long id) {
		return new ResponseEntity(service.delete(details.getUsername(), id), HttpStatus.OK);
	}
}
