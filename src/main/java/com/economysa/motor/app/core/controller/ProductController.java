package com.economysa.motor.app.core.controller;

import com.economysa.motor.app.core.entity.Product;
import com.economysa.motor.app.core.service.ProductService;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
    name = "Productos",
    description = "Endpoint donde se encuentran las operaciones respecto al recurso Producto."
)
@RestController
@RequestMapping("/api/v1/secured/product")
public class ProductController {

  @Autowired private ProductService service;

  @Operation(
      description = "Listado paginado de Productos",
      summary = "Listado paginado de Productos",
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
  public ResponseEntity<Page<Product>> list(Pageable pageable) {
    return new ResponseEntity(service.list(pageable), HttpStatus.OK);
  }

  @Operation(
      description = "Busca productos por nombre",
      summary = "Busca productos por nombre",
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
  public ResponseEntity<List<Product>> search(@RequestParam String name) {
    return new ResponseEntity(service.search(name), HttpStatus.OK);
  }

  @Operation(
      description = "Obtiene un producto por ID",
      summary = "Obtiene un producto por ID",
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
              description = "No se encontró el recurso"
          ),
          @ApiResponse(
              responseCode = "500",
              description = "Error interno del sistema"
          )
      }
  )
  @GetMapping("/{id}")
  public ResponseEntity<Product> get(
      @Parameter(name = "Identificador del recurso") @PathVariable Long id) {
    return new ResponseEntity(service.get(id), HttpStatus.OK);
  }
}
