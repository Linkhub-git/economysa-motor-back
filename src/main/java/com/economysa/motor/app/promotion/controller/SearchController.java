package com.economysa.motor.app.promotion.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.economysa.motor.app.core.controller.request.SearchRequest;
import com.economysa.motor.app.core.controller.request.SearchSaveRequest;
import com.economysa.motor.app.promotion.controller.response.SearchResponse;
import com.economysa.motor.app.promotion.service.SearchConditionService;
import com.economysa.motor.app.promotion.service.SearchGroupService;
import com.economysa.motor.app.promotion.service.SearchService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(
    name = "Mecánicas",
    description = "Endpoint donde se encuentran las operaciones respecto al recurso Mecánica."
)
@RestController
@RequestMapping("/api/v1/secured/search")
public class SearchController {

	  @Autowired private SearchService service;
	  @Autowired private SearchGroupService serviceGroup;
	  @Autowired private SearchConditionService serviceCondition;

  @Operation(
      description = "Obtener reglas de busqueda",
      summary = "Obtener reglas de busqueda",
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

  @GetMapping("/{id}/{type}")
  public ResponseEntity<SearchResponse> search(@PathVariable Long id,@PathVariable String type) {
    return new ResponseEntity(service.list(type,id), HttpStatus.OK);
  }

  @Operation(
      description = "Crea reglas de busqueda",
      summary = "Crea reglas de busqueda",
      method = "POST"
  )
  @ApiResponses(
      {
          @ApiResponse(
              responseCode = "200",
              description = "Operación exitosa"
          ),
          @ApiResponse(
              responseCode = "400",
              description = "Error al enviar los datos del request"
          ),
          @ApiResponse(
              responseCode = "500",
              description = "Error interno del sistema"
          )
      }
  )
  
  @PostMapping
  public ResponseEntity<SearchResponse> create(@AuthenticationPrincipal UserDetails details,
                                         @Valid @RequestBody SearchSaveRequest request) {
	  
    return new ResponseEntity(service.create(details.getUsername(), request), HttpStatus.CREATED);
  }

  @Operation(
      description = "Actualiza reglas de busqueda",
      summary = "Actualiza reglas de busqueda",
      method = "PUT"
  )
  @ApiResponses(
      {
          @ApiResponse(
              responseCode = "200",
              description = "Operación exitosa"
          ),
          @ApiResponse(
              responseCode = "400",
              description = "Error al enviar los datos del request"
          ),
          @ApiResponse(
              responseCode = "500",
              description = "Error interno del sistema"
          )
      }
  )
  
  @PutMapping("/{id}")
  public ResponseEntity<SearchResponse> createConditions(@AuthenticationPrincipal UserDetails details,
                                         @Valid @RequestBody SearchSaveRequest request) {
    return new ResponseEntity(service.update(details.getUsername(), request), HttpStatus.OK);
  }

	  @Operation(
	      description = "Elimina regla de busqueda",
	      summary = "Elimina regla de busqueda",
	      method = "DELETE"
	  )
	  @ApiResponses(
	      {
	          @ApiResponse(
	              responseCode = "200",
	              description = "Operación exitosa"
	          ),
	          @ApiResponse(
	              responseCode = "404",
	              description = "No se encontró el recurso Mecánica"
	          ),
	          @ApiResponse(
	              responseCode = "500",
	              description = "Error interno del sistema"
	          )
	      }
	  )
	  @DeleteMapping("/{id}")
	  public ResponseEntity<SearchResponse> delete(@AuthenticationPrincipal UserDetails details,
	                                         @Parameter(name = "Identificador del recurso")
	                                         @PathVariable Long id) {
	    return new ResponseEntity(service.delete(details.getUsername(), id), HttpStatus.OK);
	  }
  
  	  @Operation(
	      description = "Elimina un grupo",
	      summary = "Elimina un condicion",
	      method = "DELETE"
	  )
	  @ApiResponses(
	      {
	          @ApiResponse(
	              responseCode = "200",
	              description = "Operación exitosa"
	          ),
	          @ApiResponse(
	              responseCode = "404",
	              description = "No se encontró el recurso Mecánica"
	          ),
	          @ApiResponse(
	              responseCode = "500",
	              description = "Error interno del sistema"
	          )
	      }
	  )
	  @DeleteMapping("/group/{id}")
	  public ResponseEntity<SearchResponse> deleteGroup(@AuthenticationPrincipal UserDetails details,
	                                         @Parameter(name = "Identificador del recurso")
	                                         @PathVariable Long id) {
	    return new ResponseEntity(serviceGroup.delete(details.getUsername(), id), HttpStatus.OK);
	  }
  
  	  @Operation(
	      description = "Elimina un condicion",
	      summary = "Elimina un condicion",
	      method = "DELETE"
	  )
	  @ApiResponses(
	      {
	          @ApiResponse(
	              responseCode = "200",
	              description = "Operación exitosa"
	          ),
	          @ApiResponse(
	              responseCode = "404",
	              description = "No se encontró el recurso Mecánica"
	          ),
	          @ApiResponse(
	              responseCode = "500",
	              description = "Error interno del sistema"
	          )
	      }
	  )
	  @DeleteMapping("/condition/{id}")
	  public ResponseEntity<SearchResponse> deleteCondition(@AuthenticationPrincipal UserDetails details,
	                                         @Parameter(name = "Identificador del recurso")
	                                         @PathVariable Long id) {
	    return new ResponseEntity(serviceCondition.delete(details.getUsername(), id), HttpStatus.OK);
	  }
  
  
}
