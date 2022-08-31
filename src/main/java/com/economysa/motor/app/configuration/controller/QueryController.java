package com.economysa.motor.app.configuration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.economysa.motor.app.configuration.entity.QueryCondition;
import com.economysa.motor.app.configuration.entity.QueryField;
import com.economysa.motor.app.configuration.entity.QueryOperator;
import com.economysa.motor.app.configuration.service.QueryConditionService;
import com.economysa.motor.app.configuration.service.QueryFieldService;
import com.economysa.motor.app.configuration.service.QueryOperatorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(
      name = "Condition",
      description = "Endpoint donde se encuentran las operaciones respecto al recurso consulta condiciones."
)
@RestController
@RequestMapping("/api/v1/secured/query")
public class QueryController {

	  @Autowired private QueryConditionService queryConditionService;
	  @Autowired private QueryFieldService queryFieldService;
	  @Autowired private QueryOperatorService queryOperatorService;


  @Operation(
      description = "Listado de Condiciones",
      summary = "Listado de Condiciones",
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
  @GetMapping("/condition")
  public ResponseEntity<List<QueryCondition>> listConditions() {
    return new ResponseEntity<>(queryConditionService.listConditions(), HttpStatus.OK);
  }
  
  @Operation(
	      description = "Listado de campos",
	      summary = "Listado de campos",
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
	  @GetMapping("/field")
	  public ResponseEntity<List<QueryField>> listFields() {
	    return new ResponseEntity<>(queryFieldService.listFields(), HttpStatus.OK);
	  }
  
  	@Operation(
	      description = "Listado de operadores",
	      summary = "Listado de operadores",
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
	  @GetMapping("/operator")
	  public ResponseEntity<List<QueryOperator>> listOperator() {
	    return new ResponseEntity<>(queryOperatorService.listOperators(), HttpStatus.OK);
	  }
}
