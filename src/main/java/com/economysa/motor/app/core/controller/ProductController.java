package com.economysa.motor.app.core.controller;

import com.economysa.motor.app.core.controller.request.SearchRequest;
import com.economysa.motor.app.core.entity.Product;
import com.economysa.motor.app.core.entity.Provider;
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

import javax.validation.Valid;

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
	      description = "Lista productos por filtros",
	      summary = "Lista productos por filtros",
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
  @PostMapping("/filter")
  public ResponseEntity<List<Product>> filter(@Valid @RequestBody SearchRequest req) {
	  
    return new ResponseEntity(service.filter(req), HttpStatus.OK);
  }
  
  
  @Operation(
      description = "Lista productos por nombre producto",
      summary = "Lista productos por nombre producto",
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
  @GetMapping("/name")
  public ResponseEntity<List<Product>> listByProductName(@RequestParam String name) {
    return new ResponseEntity(service.listByProductName(name), HttpStatus.OK);
  }

  
  @Operation(
      description = "Obtiene un producto por ID producto",
      summary = "Obtiene un producto por ID producto",
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
  public ResponseEntity<Product> listByProductId(
      @Parameter(name = "Id de producto") @PathVariable Long id) {
    return new ResponseEntity(service.get(id), HttpStatus.OK);
  }

  
  @Operation(
	      description = "Obtiene un producto por codigo",
	      summary = "Obtiene un producto por codigo",
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
	  public ResponseEntity<Product> listByProductCode(
	      @Parameter(name = "Codigo de producto") @PathVariable String code) {
	    return new ResponseEntity(service.listByProductCode(code), HttpStatus.OK);
	  }
  
  //PROVIDER
  
  @Operation(
          description = "Lista productos por el nombre del proveedor",
          summary = "Lista productos por el nombre del proveedor",
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
  @GetMapping("/provider")
  public ResponseEntity<List<Product>> listByProviderName(
          @Parameter(name = "	Nombre del proveedor") @RequestParam String name) {
      return new ResponseEntity(service.listByProviderName(name), HttpStatus.OK);
  }
  
    @Operation(
            description = "Lista productos por el ID del proveedor",
            summary = "Lista productos por el ID del proveedor",
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
    @GetMapping("provider/id/{id}")
    public ResponseEntity<List<Product>> listByProviderId(
            @Parameter(name = "ID del proveedor") @PathVariable Long id) {
        return new ResponseEntity(service.listByProviderId(id), HttpStatus.OK);
    }

        
    @Operation(
            description = "Lista productos por el código del proveedor",
            summary = "Lista productos por el código del proveedor",
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
    @GetMapping("provider/code/{code}")
    public ResponseEntity<List<Product>> listByProviderCode(
            @Parameter(name = "Código del proveedor") @PathVariable String code) {
        return new ResponseEntity(service.listByProviderCode(code), HttpStatus.OK);
    }
    
    
    //BRAND

    @Operation(
            description = "Lista productos por el nombre de la marca",
            summary = "Lista productos por el nombre de la marca",
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
    @GetMapping("/brand")
    public ResponseEntity<List<Product>> listByBrandName(
            @Parameter(name = "Nombre de la marca") @RequestParam String name) {
        return new ResponseEntity(service.listByBrandName(name), HttpStatus.OK);
    }

    
    @Operation(
            description = "Lista productos por el ID de la marca",
            summary = "Lista productos por el ID de la marca",
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
    @GetMapping("/brand/id/{id}")
    public ResponseEntity<List<Product>> listByBrandId(
            @Parameter(name = "ID de la marca") @PathVariable Long id) {
        return new ResponseEntity(service.listByBrandId(id), HttpStatus.OK);
    }

    
    //CATEGORY

    @Operation(
            description = "Lista productos por el nombre de la categoria",
            summary = "Lista productos por el nombre de la categoria",
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
    @GetMapping("/category")
    public ResponseEntity<List<Product>> listByCategoryName(
            @Parameter(name = "Nombre de la categoria") @RequestParam String name) {
        return new ResponseEntity(service.listByCategoryName(name), HttpStatus.OK);
    }
    
    
    @Operation(
            description = "Lista productos por el ID de la categoria",
            summary = "Lista productos por el ID de la categoria",
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
    @GetMapping("/category/id/{id}")
    public ResponseEntity<List<Product>> listByCategoriaId(
            @Parameter(name = "ID de la categoria") @PathVariable Long id) {
        return new ResponseEntity(service.listByCategoryId(id), HttpStatus.OK);
    }

   

}


