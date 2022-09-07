package com.economysa.motor.app.promotion.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.economysa.motor.app.promotion.controller.request.ConditionRulesRequest;
import com.economysa.motor.app.promotion.controller.response.ConditionRulesResponse;
import com.economysa.motor.app.promotion.service.ConditionRulesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(
    name = "Mecánicas",
    description = "Endpoint donde se encuentran las operaciones respecto al recurso Mecánica."
)
@RestController
@RequestMapping("/api/v1/secured/condition")
public class ConditionRulesController {

  @Autowired private ConditionRulesService service;

  @Operation(
      description = "Listado condiciones por tipo",
      summary = "Listado condiciones por tipo",
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

  @GetMapping("/{id}/{type}")
  public ResponseEntity<ConditionRulesResponse> list(@PathVariable Long id,@PathVariable String type) {
    return new ResponseEntity(service.list(type,id), HttpStatus.OK);
  }

  @Operation(
      description = "Crea condicion",
      summary = "Crea condicion",
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
  
  @PostMapping("/create")
  public ResponseEntity<ConditionRulesResponse> create(@AuthenticationPrincipal UserDetails details,
                                         @Valid @RequestBody ConditionRulesRequest request) {
	  
    return new ResponseEntity(service.create(details.getUsername(), request), HttpStatus.CREATED);
  }

  @Operation(
      description = "Crea lista de condiciones",
      summary = "Crea lista de condiciones",
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
  
  @PostMapping("/create_conditions")
  public ResponseEntity<ConditionRulesResponse> createConditions(@AuthenticationPrincipal UserDetails details,
                                         @Valid @RequestBody ConditionRulesRequest request) {
    return new ResponseEntity(service.createConditions(details.getUsername(), request), HttpStatus.OK);
  }

  @Operation(
      description = "Elimina un condicion",
      summary = "Elimina un condicion",
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
  public ResponseEntity<ConditionRulesResponse> delete(@AuthenticationPrincipal UserDetails details,
                                         @Parameter(name = "Identificador del recurso")
                                         @PathVariable Long id) {
    return new ResponseEntity(service.delete(details.getUsername(), id), HttpStatus.OK);
  }
}
