package com.economysa.motor.app.core.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.economysa.motor.app.core.controller.request.SearchRequest;
import com.economysa.motor.app.core.entity.Customer;
import com.economysa.motor.app.core.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(
    name = "Clientes",
    description = "Endpoint donde se encuentran las operaciones respecto al recurso Cliente."
)
@RestController
@RequestMapping("/api/v1/secured/customer")
public class CustomerController {

  @Autowired private CustomerService service;

  @Operation(
      description = "Listado paginado de Clientes",
      summary = "Listado paginado de Clientes",
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
  public ResponseEntity<Page<Customer>> list(Pageable pageable) {
    return new ResponseEntity(service.list(pageable), HttpStatus.OK);
  }

  @Operation(
	      description = "Lista clientes por filtros",
	      summary = "Lista clientes por filtros",
	      method = "POST"
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
  @PostMapping("/conditions")
  public ResponseEntity<List<Customer>> findByConditions(@Valid @RequestBody SearchRequest req) {
	  
    return new ResponseEntity(service.findByConditions(req), HttpStatus.OK);
  }
  

  @Operation(
      description = "Obtiene un cliente por ID",
      summary = "Obtiene un cliente por ID",
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
  @GetMapping("/id/{id}")
  public ResponseEntity<Customer> getByCustomerId(
      @Parameter(name = "Id de cliente") @PathVariable Long id) {
    return new ResponseEntity(service.get(id), HttpStatus.OK);
  }

  
  @Operation(
	      description = "Obtiene un cliente por codigo",
	      summary = "Obtiene un cliente por codigo",
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
	  @GetMapping("/code/{code}")
	  public ResponseEntity<Customer> getByCustomerCode(
	      @Parameter(name = "Codigo de cliente") @PathVariable String code) {
	    return new ResponseEntity(service.getByCustomerCode(code), HttpStatus.OK);
	  }
   

}


