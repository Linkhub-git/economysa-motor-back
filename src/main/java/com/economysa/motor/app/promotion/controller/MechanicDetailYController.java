package com.economysa.motor.app.promotion.controller;

import com.economysa.motor.app.promotion.controller.request.MechanicDetailYRequest;
import com.economysa.motor.app.promotion.entity.MechanicDetailY;
import com.economysa.motor.app.promotion.service.MechanicDetailYService;
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
    name = "Detalle de Mecánicas Inclusiva",
    description = "Endpoint donde se encuentran las operaciones respecto al recurso Detalle Mecánica Inclusiva."
)
@RestController
@RequestMapping("/api/v1/secured/mechanic_detail_y")
public class MechanicDetailYController {

  @Autowired private MechanicDetailYService service;

  @Operation(
      description = "Listado de Detalle de Mecánicas inclusivas",
      summary = "Listado de Detalle de Mecánicas inclusivas",
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
  public ResponseEntity<List<MechanicDetailY>> list(@RequestParam Long mechanicId) {
    return new ResponseEntity(service.list(mechanicId), HttpStatus.OK);
  }

  @Operation(
      description = "Agrega un detalle a la Mecánica inclusivq",
      summary = "Agrega un detalle a la Mecánica inclusiva",
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
  public ResponseEntity<MechanicDetailY> add(@Valid @RequestBody MechanicDetailYRequest request) {
    return new ResponseEntity(service.add(request), HttpStatus.CREATED);
  }
}
