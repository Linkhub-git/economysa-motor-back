package com.economysa.motor.app.promotion.controller;

import com.economysa.motor.app.promotion.controller.request.MechanicRulesRequest;
import com.economysa.motor.app.promotion.entity.MechanicRule;
import com.economysa.motor.app.promotion.service.MechanicRuleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(
        name = "",
        description = "Endpoint donde se encuentran las operaciones respecto al recurso Detalle de Mecánica."
)
@RestController
@RequestMapping("/api/v1/secured/mechanic_rules")
public class MechanicRuleController {

    @Autowired private MechanicRuleService service;
    
//    @Operation(
//            description = "Agrega un listado de reglas a la Mecánica",
//            summary = "Agrega un listado de reglas a la Mecánica",
//            method = "POST"
//    )
//    @ApiResponses(
//            {
//                    @ApiResponse(
//                            responseCode = "201",
//                            description = "Operación exitosa"
//                    ),
//                    @ApiResponse(
//                            responseCode = "500",
//                            description = "Error interno del sistema"
//                    )
//            }
//    )
//    @PostMapping
//    public ResponseEntity<MechanicRule> add(@Valid @RequestBody MechanicRulesRequest request) {
//        return new ResponseEntity(service.add(request), HttpStatus.CREATED);
//    }
}
