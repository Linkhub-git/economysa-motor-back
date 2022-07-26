package com.economysa.motor.app.promotion.service.impl;


import com.economysa.motor.app.promotion.controller.request.MechanicDetailRequest;
import com.economysa.motor.app.promotion.controller.request.MechanicRuleRequest;
import com.economysa.motor.app.promotion.entity.MechanicRule;
import com.economysa.motor.app.promotion.repository.MechanicRuleRepository;
import com.economysa.motor.app.promotion.service.MechanicRuleService;
import com.economysa.motor.app.promotion.service.MechanicService;
import com.economysa.motor.error.exception.BadRequestException;
import com.economysa.motor.util.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MechanicRuleServiceImpl implements MechanicRuleService {

    @Autowired private MechanicRuleRepository repository;

    @Autowired private MechanicService mechanicService;

    /**
     * Lista todos las reglas asociadas a una mecánica.
     * @param mechanicId - Identificador de la mecánica
     * @return - Listado de reglas asociadas a la mecánica.
     */
    @Override
    public List<MechanicRule> list(Long mechanicId) {
        return repository.findAll(mechanicId);
    }

    /**
     * Agrega un nuevo item ( no repetido ) a las reglas
     * de la mecánica.
     * @param request - Item a registrar
     * @return - Retorna el item ya registrado.
     */
    @Override
    public MechanicRule add(MechanicRuleRequest request) {
        MechanicRule rule = init(request);
        validateRequest(request);
        return repository.save(rule);
    }

    /**
     * Inicializa un objeto MechanicDetail.
     * @param request - Item a registrar
     * @return - Retorna el objeto inicializado.
     */
    private MechanicRule init(MechanicRuleRequest request) {
        MechanicRule rule = new MechanicRule();
        rule.setMechanic(mechanicService.get(request.getMechanic()));
        rule.setStartRange(request.getStartRange());
        rule.setEndRange(request.getEndRange());
        rule.setFactor(request.getFactor());
        rule.setPriority(request.getPriority());
        return rule;
    }

    /**
     * Verifica si un item ya ha sido registrado
     * en las reglas de la mecánica.
     * @param request - Item a registrar
     * @throws BadRequestException - Lanza excepción si el
     * item ya se encuentra registrado.
     */
    private void validateRequest(MechanicRuleRequest request) {

        if (repository.findByMechanicAndStartRangeAndEndRange(request.getMechanic(), request.getStartRange(), request.getEndRange()).isPresent()) {
            log.info(ConstantMessage.ITEM_ALREADY_ADDED);
            throw new BadRequestException(ConstantMessage.ITEM_ALREADY_ADDED);
        }

        if (repository.findByMechanicAndStartRangeAndEndRangeAndFactor(request.getMechanic(), request.getStartRange(), request.getEndRange(), request.getFactor()).isPresent()) {
            log.info(ConstantMessage.ITEM_ALREADY_ADDED);
            throw new BadRequestException(ConstantMessage.ITEM_ALREADY_ADDED);
        }

        if (repository.findByMechanicAndFactor(request.getMechanic(), request.getFactor()).isPresent()) {
            log.info(ConstantMessage.ITEM_ALREADY_ADDED);
            throw new BadRequestException(ConstantMessage.ITEM_ALREADY_ADDED);
        }

        // Valida el identificador
        if (request.getType().equals(ConstantMessage.MECHANIC_TYPE_PROVIDER)) {
            providerService.get(request.getIdentifier());
        } else if (request.getType().equals(ConstantMessage.MECHANIC_TYPE_ARTICLE)) {
            productService.get(request.getIdentifier());
        } else if (request.getType().equals(ConstantMessage.MECHANIC_TYPE_CATEGORY)) {
            categoryService.get(request.getIdentifier());
        } else if (request.getType().equals(ConstantMessage.MECHANIC_TYPE_BRAND)) {
            brandService.get(request.getIdentifier());
        } else {
            throw new IllegalArgumentException("Invalid Mechanic Type");
        }
    }
}
