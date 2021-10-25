package com.economysa.motor.app.core.controller;

import com.economysa.motor.app.core.controller.request.ProductRequest;
import com.economysa.motor.app.core.entity.Product;
import com.economysa.motor.app.core.service.ProductService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/secured/product")
@Api(tags = "Productos")
public class ProductController {

  @Autowired private ProductService service;

  @ApiOperation(
      value = "Listado de Productos paginado",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      response = Page.class,
      httpMethod = "GET"
  )
  @ApiResponses({
      @ApiResponse(
          code = 200,
          message = "Listado paginado de Productos",
          response = Page.class
      ),
      @ApiResponse(
          code = 401,
          message = "No está autorizado para realizar esta consulta"
      )
  })
  @GetMapping
  public ResponseEntity<Page<Product>> list(Pageable pageable) {
    return new ResponseEntity(service.list(pageable), HttpStatus.OK);
  }

  @GetMapping("/search")
  public ResponseEntity<List<Product>> search(@RequestParam String name) {
    return new ResponseEntity(service.search(name), HttpStatus.OK);
  }

  @ApiOperation(
      value = "Obtiene un Producto por su Identificador",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      response = Product.class,
      httpMethod = "GET"
  )
  @ApiResponses({
      @ApiResponse(
          code = 200,
          message = "Obtiene un Producto por su Identificador",
          response = Product.class
      ),
      @ApiResponse(
          code = 401,
          message = "No está autorizado para realizar esta consulta"
      ),
      @ApiResponse(
          code = 404,
          message = "El recurso solicitado no existe"
      )
  })
  @GetMapping("/{id}")
  public ResponseEntity<Product> get(@ApiParam(value = "Identificador del Producto", required = true)
                                     @PathVariable Long id) {
    return new ResponseEntity(service.get(id), HttpStatus.OK);
  }

  @ApiOperation(
      value = "Registra la información de un Producto en el sistema",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      response = Product.class,
      httpMethod = "POST"
  )
  @ApiResponses({
      @ApiResponse(
          code = 201,
          message = "El Producto ha sido registrado correctamente",
          response = Product.class
      ),
      @ApiResponse(
          code = 401,
          message = "No está autorizado para realizar esta operación"
      ),
      @ApiResponse(
          code = 404,
          message = "El recurso solicitado no existe"
      ),
      @ApiResponse(
          code = 409,
          message = "El identificador ingresado ya existe en el sistema"
      )
  })
  @PostMapping
  public ResponseEntity<Product> create(@AuthenticationPrincipal UserDetails details,
                                        @ApiParam(value = "Cuerpo de la petición", required = true)
                                        @Valid @RequestBody ProductRequest request) {
    return new ResponseEntity(service.create(details.getUsername(), request), HttpStatus.CREATED);
  }

  @ApiOperation(
      value = "Actualiza la información de un Producto en el sistema",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      response = Product.class,
      httpMethod = "PUT"
  )
  @ApiResponses({
      @ApiResponse(
          code = 200,
          message = "La información ha sido actualizada correctamente",
          response = Product.class
      ),
      @ApiResponse(
          code = 401,
          message = "No está autorizado para realizar esta operación"
      ),
      @ApiResponse(
          code = 404,
          message = "El recurso solicitado no existe"
      )
  })
  @PutMapping("/{id}")
  public ResponseEntity<Product> update(@AuthenticationPrincipal UserDetails details,
                                        @ApiParam(value = "Identificador del Producto", required = true)
                                        @PathVariable Long id,
                                        @ApiParam(value = "Cuerpo de la petición", required = true)
                                        @Valid @RequestBody ProductRequest request) {
    return new ResponseEntity(service.update(details.getUsername(), id, request), HttpStatus.OK);
  }

  @ApiOperation(
      value = "Elimina de forma permanente un Producto en el sistema",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      response = Product.class,
      httpMethod = "DELETE"
  )
  @ApiResponses({
      @ApiResponse(
          code = 200,
          message = "El Producto ha sido eliminado correctamente",
          response = Product.class
      ),
      @ApiResponse(
          code = 401,
          message = "No está autorizado para realizar esta operación"
      ),
      @ApiResponse(
          code = 404,
          message = "El recurso solicitado no existe"
      )
  })
  @DeleteMapping("/{id}")
  public ResponseEntity<Product> delete(@AuthenticationPrincipal UserDetails details,
                                        @ApiParam(value = "Identificador del Producto", required = true)
                                        @PathVariable Long id) {
    return new ResponseEntity(service.delete(details.getUsername(), id), HttpStatus.OK);
  }
}
