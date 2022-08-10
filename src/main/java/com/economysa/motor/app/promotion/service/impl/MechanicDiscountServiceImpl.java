package com.economysa.motor.app.promotion.service.impl;

import com.economysa.motor.app.core.service.ProductService;
import com.economysa.motor.app.promotion.controller.request.MechanicDiscountRequest;
import com.economysa.motor.app.promotion.entity.MechanicDiscount;
import com.economysa.motor.app.promotion.repository.MechanicDiscountRepository;
import com.economysa.motor.app.promotion.service.MechanicDiscountService;
import com.economysa.motor.app.promotion.service.MechanicRuleService;
import com.economysa.motor.error.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class MechanicDiscountServiceImpl implements MechanicDiscountService {

    @Autowired private MechanicDiscountRepository repository;
    @Autowired private MechanicRuleService mechanicRuleService;
    @Autowired private ProductService productService;

    private MechanicDiscount init(MechanicDiscountRequest request) {
        MechanicDiscount discount = new MechanicDiscount();
        //discount.setMechanicRules(mechanicRuleService.get(request.getMechanicRule()));
        discount.setPercentageDiscount(request.getPercentageDiscount());
        return discount;
    }

    @Override
    public List<MechanicDiscount> list(Long mechanicRulesId) {
        return repository.findAll(mechanicRulesId);
    }

    @Override
    public MechanicDiscount add(MechanicDiscountRequest request) {
        MechanicDiscount discount = init(request);
        validateRequest(request);
        return repository.save(discount);
    }

    private void validateRequest(MechanicDiscountRequest request) {
            if (repository.findByMechanicAndDiscount(request.getMechanicRule(),
                    request.getPercentageDiscount()).isPresent()) {
                throw new BadRequestException("Item already added");
            }
    }
}

