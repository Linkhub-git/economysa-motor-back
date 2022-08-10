package com.economysa.motor.app.promotion.controller;

import com.economysa.motor.app.promotion.controller.request.MechanicDiscountRequest;
import com.economysa.motor.app.promotion.entity.MechanicDiscount;
import com.economysa.motor.app.promotion.service.MechanicDiscountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(
        name = "Descuentos de la Mecánica",
        description = "Endpoint donde se encuentran las operaciones respecto al recurso Descuento de Mecánica."
)
@RestController
@RequestMapping("/api/v1/secured/mechanic_discount")
public class MechanicDiscountController {
    @Autowired
    private MechanicDiscountService service;

    @Operation(
            description = "Listado de Descuentos de una regla de la Mecánica",
            summary = "Listado de Descuentos de una regla de la Mecánica",
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
    public ResponseEntity<List<MechanicDiscount>> list(@RequestParam Long mechanicRulesId) {
        return new ResponseEntity(service.list(mechanicRulesId), HttpStatus.OK);
    }

    @Operation(
            description = "Agrega un Descuento a la regla de la Mecánica",
            summary = "Agrega una Descuento a la regla de la Mecánica",
            method = "GET"
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Operación exitosa"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error interno del sistema"
                    )
            }
    )
    @PostMapping
    public ResponseEntity<MechanicDiscount> add(@Valid @RequestBody MechanicDiscountRequest request) {
        return new ResponseEntity(service.add(request), HttpStatus.CREATED);
    }
}
