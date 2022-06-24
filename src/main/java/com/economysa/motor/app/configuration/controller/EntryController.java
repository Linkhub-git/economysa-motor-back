package com.economysa.motor.app.configuration.controller;

import com.economysa.motor.app.configuration.entity.Entry;
import com.economysa.motor.app.configuration.service.EntryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(
    name = "Giros de negocio",
    description = "Endpoint donde se encuentran las operaciones" +
        " respecto al recurso Giro de negocio."
)
@RestController
@RequestMapping("/api/v1/secured/entry")
public class EntryController {

  @Autowired private EntryService service;

  @Operation(
      description = "Listado de Giros de Negocio",
      summary = "Listado de Giros de Negocio",
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
  public ResponseEntity<List<Entry>> list(
      @Parameter(name = "listPrice", description = "Identificador de la lista de precio",
          required = true)
      @RequestParam Long listPrice) {
    return new ResponseEntity<>(service.listByListPrice(listPrice), HttpStatus.OK);
  }

  @Operation(
      description = "Búsqueda de Giros de negocio ingresando un" +
          " parámetro opcional",
      summary = "Búsqueda de Giros de negocio ingresando un" +
          " parámetro opcional",
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
  @GetMapping("/search")
  public ResponseEntity<List<Entry>> search(
      @Parameter(name = "query", description = "Texto de búsqueda", required = true)
      @RequestParam String query) {
    return new ResponseEntity<>(service.search(query), HttpStatus.OK);
  }
}
