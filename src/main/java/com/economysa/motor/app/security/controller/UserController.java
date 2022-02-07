package com.economysa.motor.app.security.controller;

import com.economysa.motor.app.security.controller.dto.UpdateUserDto;
import com.economysa.motor.app.security.controller.dto.UserDto;
import com.economysa.motor.app.security.entity.User;
import com.economysa.motor.app.security.service.UserService;
import com.economysa.motor.util.MessageResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
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
			summary = "Listado paginado de usuarios"
	)
	@ApiResponse(
			responseCode = "200",
			description = "Operación exitosa"
	)
	@GetMapping
	public ResponseEntity<Page<User>> list(Pageable pageable) {
		return new ResponseEntity<>(service.list(pageable), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> get(@PathVariable Long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<User> create(@AuthenticationPrincipal UserDetails details,
																		 @Valid @RequestBody UserDto dto) {
		return new ResponseEntity<>(service.create(details.getUsername(), dto), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable Long id,
																		 @AuthenticationPrincipal UserDetails details,
																		 @Valid @RequestBody UpdateUserDto dto) {
		return new ResponseEntity<>(service.update(details.getUsername(), id, dto), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<MessageResponse> delete(@PathVariable Long id,
																								@AuthenticationPrincipal UserDetails details) {
		return new ResponseEntity<>(service.delete(details.getUsername(), id), HttpStatus.OK);
	}
}
