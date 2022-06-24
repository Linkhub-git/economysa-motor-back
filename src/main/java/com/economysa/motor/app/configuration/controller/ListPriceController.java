package com.economysa.motor.app.configuration.controller;

import com.economysa.motor.app.configuration.entity.ListPrice;
import com.economysa.motor.app.configuration.service.ListPriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(
    name = "Listas de Precios",
    description = "Endpoint donde se encuentran las operaciones" +
        " respecto al recurso Listas de Precios"
)
@RestController
@RequestMapping("/api/v1/secured/list_price")
public class ListPriceController {

  @Autowired private ListPriceService service;

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
  @GetMapping
  public ResponseEntity<List<ListPrice>> list() {
    return new ResponseEntity<>(service.list(), HttpStatus.OK);
  }

  @Operation(
      description = "Obtiene una Lista de Precio por ID",
      summary = "Obtiene una Lista de Precio por ID",
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
  public ResponseEntity<ListPrice> get(@PathVariable Long id) {
    return new ResponseEntity<>(service.get(id), HttpStatus.OK);
  }
}
