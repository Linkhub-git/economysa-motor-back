package com.economysa.motor.app.promotion.controller;

import com.economysa.motor.app.promotion.controller.request.InputOrderRequest;
import com.economysa.motor.app.promotion.controller.response.OutputOrder;
import com.economysa.motor.app.promotion.service.CheckPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/public/check_promotion")
public class CheckPromotionController {

    @Autowired
    private CheckPromotionService service;

    @PostMapping
    public ResponseEntity<OutputOrder> apply(InputOrderRequest request) {
        return new ResponseEntity(service.apply(request), HttpStatus.OK);
    }
}
