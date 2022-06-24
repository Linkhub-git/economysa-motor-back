package com.economysa.motor.app.promotion.controller;

import com.economysa.motor.app.promotion.controller.request.MechanicDetailRequest;
import com.economysa.motor.app.promotion.entity.MechanicDetail;
import com.economysa.motor.app.promotion.service.MechanicDetailService;
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
    name = "Detalle de la Mecánica",
    description = "Endpoint donde se encuentran las operaciones respecto al recurso Detalle de Mecánica."
)
@RestController
@RequestMapping("/api/v1/secured/mechanic_detail")
public class MechanicDetailController {

  @Autowired private MechanicDetailService service;

  @Operation(
      description = "Listado de detalle de Mecánica",
      summary = "Listado de detalle de Mecánica",
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
  public ResponseEntity<List<MechanicDetail>> list(@RequestParam Long mechanic) {
    return new ResponseEntity(service.list(mechanic), HttpStatus.OK);
  }

  @Operation(
      description = "Agrega un detalle a la Mecánica",
      summary = "Agrega un detalle a la Mecánica",
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
  public ResponseEntity<MechanicDetail> add(@Valid @RequestBody MechanicDetailRequest request) {
    return new ResponseEntity(service.add(request), HttpStatus.CREATED);
  }
}
