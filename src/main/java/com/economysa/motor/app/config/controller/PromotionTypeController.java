package com.economysa.motor.app.config.controller;

import com.economysa.motor.app.config.entity.PromotionType;
import com.economysa.motor.app.config.service.PromotionTypeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/secured/promotion_type")
@Api(tags = "Tipos de Promoción")
public class PromotionTypeController {

  @Autowired private PromotionTypeService service;

  @ApiOperation(
      value = "Listado de Tipos de Promoción",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      response = List.class,
      httpMethod = "GET"
  )
  @ApiResponses({
      @ApiResponse(
          code = 200,
          message = "Listado de Tipos de Promoción",
          response = List.class
      ),
      @ApiResponse(
          code = 401,
          message = "No está autorizado para realizar esta consulta"
      )
  })
  @GetMapping
  public ResponseEntity<List<PromotionType>> list() {
    return new ResponseEntity(service.list(), HttpStatus.OK);
  }

  @ApiOperation(
      value = "Obtiene un Tipo de Promoción por su Identificador",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      response = PromotionType.class,
      httpMethod = "GET"
  )
  @ApiResponses({
      @ApiResponse(
          code = 200,
          message = "Obtiene un Tipo de Promoción por su Identificador",
          response = PromotionType.class
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
  public ResponseEntity<PromotionType> get(@ApiParam(value = "Identificador del Tipo de Promoción", required = true)
                                           @PathVariable Long id) {
    return new ResponseEntity(service.get(id), HttpStatus.OK);
  }
}
