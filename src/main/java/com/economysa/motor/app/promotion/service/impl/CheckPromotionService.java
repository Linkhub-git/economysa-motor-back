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

        List<Mechanic> list = mechanicService.findActive();

        List<Long> ids = new ArrayList<Long>();

        for (Mechanic m : list) {
            ids.add(m.getId());
        }

        mechanicDetailService.list(ids);


        return null;
    }
}
