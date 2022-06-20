package com.economysa.motor.app.promotion.service;

import com.economysa.motor.app.promotion.controller.request.InputOrderRequest;
import com.economysa.motor.app.promotion.controller.response.OutputOrder;

public interface CheckPromotionService {

    OutputOrder apply(InputOrderRequest request);
}
