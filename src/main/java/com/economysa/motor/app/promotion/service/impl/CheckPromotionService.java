package com.economysa.motor.app.promotion.service.impl;

import com.economysa.motor.app.promotion.controller.request.InputOrderRequest;
import com.economysa.motor.app.promotion.controller.response.OutputOrder;
import com.economysa.motor.app.promotion.entity.Mechanic;
import com.economysa.motor.app.promotion.entity.MechanicDetail;
import com.economysa.motor.app.promotion.service.MechanicDetailService;
import com.economysa.motor.app.promotion.service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CheckPromotionService {

    @Autowired
    private MechanicService mechanicService;

    @Autowired
    private MechanicDetailService mechanicDetailService;

    public OutputOrder apply(InputOrderRequest request) {

        OutputOrder outputOrder = null;

        //List<Long> ids = mechanicService.findActiveIds();

        //List<MechanicDetail> products = mechanicDetailService.list(ids);


        List<Mechanic> mechanics = mechanicService.findActive();



        //for (MechanicDetail product : products){
        //
        //}


        return null;
    }
}
