package com.economysa.motor.app.promotion.service;


import com.economysa.motor.app.promotion.controller.request.MechanicDiscountRequest;
import com.economysa.motor.app.promotion.entity.MechanicDiscount;

import java.util.List;

public interface MechanicDiscountService {

    List<MechanicDiscount> list(Long mechanicRulesId);

    MechanicDiscount add(MechanicDiscountRequest request);
}
