package com.economysa.motor.app.promotion.controller;

import com.economysa.motor.app.promotion.controller.request.MechanicEntryRequest;
import com.economysa.motor.app.promotion.entity.MechanicEntry;
import com.economysa.motor.app.promotion.service.MechanicEntryService;
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
    name = "Giros de negocio asociados a una Mecánica",
    description = "Endpoint donde se encuentran las operaciones respecto a Giros" +
        " de negocio asociados a una Mecánica."
)
@RestController
@RequestMapping("/api/v1/secured/mechanic_entry")
public class MechanicEntryController {

  @Autowired
  private MechanicEntryService service;

  @Operation(
      description = "Listado de Giros de negocio de una Mecánica",
      summary = "Listado de Giros de negocio de una Mecánica",
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
  public ResponseEntity<List<MechanicEntry>> list(@RequestParam Long mechanic) {
    return new ResponseEntity<>(service.listByMechanic(mechanic), HttpStatus.OK);
  }

  @Operation(
      description = "Agrega un Giro de negocio a una Mecánica",
      summary = "Agrega un Giro de negocio a una Mecánica",
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
  @PostMapping
  public ResponseEntity<MechanicEntry> add(@Valid @RequestBody MechanicEntryRequest request) {
    return new ResponseEntity<>(service.add(request), HttpStatus.OK);
  }
}
