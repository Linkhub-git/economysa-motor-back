package com.economysa.motor.app.promotion.controller;

import com.economysa.motor.app.promotion.controller.request.MechanicRequest;
import com.economysa.motor.app.promotion.entity.Mechanic;
import com.economysa.motor.app.promotion.service.MechanicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;

@Tag(
    name = "Mecánicas",
    description = "Endpoint donde se encuentran las operaciones respecto al recurso Mecánica."
)
@RestController
@RequestMapping("/api/v1/secured/mechanic")
public class MechanicController {

  @Autowired private MechanicService service;

  @Operation(
      description = "Listado paginado de Mecánicas",
      summary = "Listado paginado de Mecánicas",
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
  public ResponseEntity<Page<Mechanic>> list(@RequestParam(required = false) String emitter, Pageable pageable) {
    return new ResponseEntity(service.list(emitter, pageable), HttpStatus.OK);
  }

  @Operation(
      description = "Obtiene una Mecánica por ID",
      summary = "Obtiene una Mecánica por ID",
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
              description = "No se encontro el recurso"
          ),
          @ApiResponse(
              responseCode = "500",
              description = "Error interno del sistema"
          )
      }
  )
  @GetMapping("/{id}")
  public ResponseEntity<Mechanic> get(@PathVariable Long id) {
    return new ResponseEntity(service.get(id), HttpStatus.OK);
  }

  @Operation(
      description = "Crea un recurso Mecánica",
      summary = "Crea un recurso Mecánica",
      method = "POST"
  )
  @ApiResponses(
      {
          @ApiResponse(
              responseCode = "200",
              description = "Operación exitosa"
          ),
          @ApiResponse(
              responseCode = "400",
              description = "Error al enviar los datos del request"
          ),
          @ApiResponse(
              responseCode = "500",
              description = "Error interno del sistema"
          )
      }
  )
  @PostMapping
  public ResponseEntity<Mechanic> create(@AuthenticationPrincipal UserDetails details,
                                         @Valid @RequestBody MechanicRequest request) throws ParseException {
    return new ResponseEntity(service.create(details.getUsername(), request), HttpStatus.CREATED);
  }

  @Operation(
      description = "Actualiza un recurso Mecánica",
      summary = "Actualiza un recurso Mecánica",
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
              description = "Error al enviar los datos del request"
          ),
          @ApiResponse(
              responseCode = "500",
              description = "Error interno del sistema"
          )
      }
  )
  @PutMapping("/{id}")
  public ResponseEntity<Mechanic> update(@AuthenticationPrincipal UserDetails details,
                                         @PathVariable Long id,
                                         @Valid @RequestBody MechanicRequest request) throws ParseException {
    return new ResponseEntity(service.update(id, details.getUsername(), request), HttpStatus.OK);
  }

  @Operation(
      description = "Elimina un recurso Mecánica",
      summary = "Elimina un recurso Mecánica",
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
              description = "No se encontró el recurso Mecánica"
          ),
          @ApiResponse(
              responseCode = "500",
              description = "Error interno del sistema"
          )
      }
  )
  @DeleteMapping("/{id}")
  public ResponseEntity<Mechanic> delete(@AuthenticationPrincipal UserDetails details,
                                         @Parameter(name = "Identificador del recurso")
                                         @PathVariable Long id) {
    return new ResponseEntity(service.delete(details.getUsername(), id), HttpStatus.OK);
  }
}
