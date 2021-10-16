package com.economysa.motor.app.config.controller;

import com.economysa.motor.app.config.entity.Modality;
import com.economysa.motor.app.config.service.ModalityService;
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
@RequestMapping("/api/v1/secured/modality")
@Api(tags = "Modalidades")
public class ModalityController {

  @Autowired private ModalityService service;

  @ApiOperation(
      value = "Listado de Modalidades",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      response = List.class,
      httpMethod = "GET"
  )
  @ApiResponses({
      @ApiResponse(
          code = 200,
          message = "Listado de Modalidades",
          response = List.class
      ),
      @ApiResponse(
          code = 401,
          message = "No está autorizado para realizar esta consulta"
      )
  })
  @GetMapping
  public ResponseEntity<List<Modality>> list() {
    return new ResponseEntity(service.list(), HttpStatus.OK);
  }

  @ApiOperation(
      value = "Obtiene una Modalidad por su Identificador",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      response = Modality.class,
      httpMethod = "GET"
  )
  @ApiResponses({
      @ApiResponse(
          code = 200,
          message = "Obtiene una Modalidad por su Identificador",
          response = Modality.class
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
  public ResponseEntity<Modality> get(@ApiParam(value = "Identificador de la Modalidad", required = true)
                                      @PathVariable Long id) {
    return new ResponseEntity(service.get(id), HttpStatus.OK);
  }
}
