package com.economysa.motor.app.promotion.controller;

import com.economysa.motor.app.promotion.controller.request.MechanicBonusRequest;
import com.economysa.motor.app.promotion.entity.MechanicBonus;
import com.economysa.motor.app.promotion.service.MechanicBonusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(
    name = "Bonificaciones de la Mecánica",
    description = "Endpoint donde se encuentran las operaciones respecto al recurso Bonificación de Mecánica."
)
@RestController
@RequestMapping("/api/v1/secured/mechanic_bonus")
public class MechanicBonusController {

  @Autowired private MechanicBonusService service;

  @Operation(
      description = "Listado de Bonificaciones de una Mecánica",
      summary = "Listado de Bonificaciones de una Mecánica",
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
  public ResponseEntity<List<MechanicBonus>> list(@RequestParam Long mechanicId) {
    return new ResponseEntity(service.list(mechanicId), HttpStatus.OK);
  }

  @Operation(
      description = "Agrega una Bonificación a la Mecánica",
      summary = "Agrega una Bonificación a la Mecánica",
      method = "GET"
  )
  @ApiResponses(
      {
          @ApiResponse(
              responseCode = "201",
              description = "Operación exitosa"
          ),
          @ApiResponse(
              responseCode = "500",
              description = "Error interno del sistema"
          )
      }
  )
  @PostMapping
  public ResponseEntity<MechanicBonus> add(@Valid @RequestBody MechanicBonusRequest request) {
    return new ResponseEntity(service.add(request), HttpStatus.CREATED);
  }
}
