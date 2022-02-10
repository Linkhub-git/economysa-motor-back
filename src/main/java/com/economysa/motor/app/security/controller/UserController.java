package com.economysa.motor.app.security.controller;

import com.economysa.motor.app.security.controller.dto.UpdateUserDto;
import com.economysa.motor.app.security.controller.dto.UserDto;
import com.economysa.motor.app.security.entity.User;
import com.economysa.motor.app.security.service.UserService;
import com.economysa.motor.util.MessageResponse;
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
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author QuickDev
 * @version 1.0
 */
@Tag(
		name = "Usuarios",
		description = "Endpoint donde se encuentran las operaciones respecto al recurso Usuario."
)
@RestController
@RequestMapping("/api/v1/secured/user")
@AllArgsConstructor
public class UserController {

	private final UserService service;

	@Operation(
			description = "Listado paginado de usuarios",
			summary = "Listado paginado de usuarios",
			method = "GET"
	)
	@ApiResponse(
			responseCode = "200",
			description = "Operación exitosa"
	)
	@GetMapping
	public ResponseEntity<Page<User>> list(
				@Parameter(name = "pageable", description = "Información de paginación. Normalmente se envía page y size.")
							Pageable pageable) {
		return new ResponseEntity<>(service.list(pageable), HttpStatus.OK);
	}

	@Operation(
				description = "Obtiene un recurso User por su ID",
				summary = "Obtiene un recurso User por su ID",
				method = "GET"
	)
	@ApiResponses(
				{
							@ApiResponse(
										responseCode = "200",
										description = "Operación exitosa"
							),
							@ApiResponse(
										responseCode = "400",
										description = "El recurso no fue encontrado"
							)
				}
	)
	@GetMapping("/{id}")
	public ResponseEntity<User> get(@PathVariable Long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}

	@Operation(
				description = "Permite crear un recurso User",
				summary = "Permite crear un recurso User",
				method = "POST"
	)
	@ApiResponses(
				{
							@ApiResponse(
										responseCode = "201",
										description = "Operación exitosa"
							),
							@ApiResponse(
										responseCode = "400",
										description = "Error al realizar la operación"
							),
							@ApiResponse(
										responseCode = "404",
										description = "El recurso no se encuentra disponible"
							),
							@ApiResponse(
										responseCode = "500",
										description = "El servicio no se encuentra activo"
							)
				}
	)
	@PostMapping
	public ResponseEntity<User> create(
				@Parameter(hidden = true)
				@AuthenticationPrincipal UserDetails details,
				@Valid @RequestBody UserDto dto) {
		return new ResponseEntity<>(service.create(details.getUsername(), dto), HttpStatus.CREATED);
	}

	@Operation(
				description = "Permite actualizar información de un usuario",
				summary = "Permite actualizar información de un usuario",
				method = "PUT"
	)
	@ApiResponses(
				{
							@ApiResponse(
										responseCode = "200",
										description = "Operación exitosa"
							),
							@ApiResponse(
										responseCode = "400",
										description = "Error al realizar la operación"
							),
							@ApiResponse(
										responseCode = "404",
										description = "El recurso no se encuentra disponible"
							),
							@ApiResponse(
										responseCode = "500",
										description = "El servicio no se encuentra activo"
							)
				}
	)
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable Long id,
																		 @Parameter(hidden = true)
																		 @AuthenticationPrincipal UserDetails details,
																		 @Valid @RequestBody UpdateUserDto dto) {
		return new ResponseEntity<>(service.update(details.getUsername(), id, dto), HttpStatus.OK);
	}

	@Operation(
				description = "Permite actualizar información de un usuario",
				summary = "Permite actualizar información de un usuario",
				method = "DELETE"
	)
	@ApiResponses(
				{
							@ApiResponse(
										responseCode = "200",
										description = "Operación exitosa"
							),
							@ApiResponse(
										responseCode = "400",
										description = "Error al realizar la operación"
							),
							@ApiResponse(
										responseCode = "404",
										description = "El recurso no se encuentra disponible"
							),
							@ApiResponse(
										responseCode = "500",
										description = "El servicio no se encuentra activo"
							)
				}
	)
	@DeleteMapping("/{id}")
	public ResponseEntity<MessageResponse> delete(
				@Parameter(name = "id", description = "ID del recurso Usuario", required = true, example = "1")
				@PathVariable Long id,
				@Parameter(hidden = true)
				@AuthenticationPrincipal UserDetails details) {
		return new ResponseEntity<>(service.delete(details.getUsername(), id), HttpStatus.OK);
	}
}
