package com.economysa.motor.app.configuration.controller;

import com.economysa.motor.app.configuration.entity.Brand;
import com.economysa.motor.app.configuration.service.BrandService;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(
      name = "Marcas",
      description = "Endpoint donde se encuentran las operaciones respecto al recurso Marca."
)
@RestController
@RequestMapping("/api/v1/secured/brand")
public class BrandController {

  @Autowired private BrandService service;

  @Operation(
        description = "Listado paginado de Marcas",
        summary = "Listado paginado de Marcas",
        method = "GET"
  )
  @ApiResponses(
        @ApiResponse(
              responseCode = "200",
              description = "Operación exitosa"
        )
  )
  @GetMapping
  public ResponseEntity<Page<Brand>> list(
        @Parameter(name = "name", description = "Nombre de alguna Marca a buscar.")
        @RequestParam(required = false, defaultValue = "") String name,
        @Parameter(name = "pageable", description = "Información de paginación. Normalmente se envía page y size.")
              Pageable pageable) {
    return new ResponseEntity<>(service.list(name, pageable), HttpStatus.OK);
  }
}
