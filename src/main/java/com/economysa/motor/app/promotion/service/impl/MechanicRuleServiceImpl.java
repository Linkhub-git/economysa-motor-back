package com.economysa.motor.app.promotion.service.impl;

import com.economysa.motor.app.promotion.controller.request.MechanicRuleRequest;
import com.economysa.motor.app.promotion.controller.request.MechanicRulesRequest;
import com.economysa.motor.app.promotion.entity.MechanicRule;
import com.economysa.motor.app.promotion.repository.MechanicRuleRepository;
import com.economysa.motor.app.promotion.service.MechanicRuleService;
import com.economysa.motor.app.promotion.service.MechanicService;
import com.economysa.motor.error.exception.BadRequestException;
import com.economysa.motor.util.ConstantMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
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
    public void add(MechanicRulesRequest request) {

        for(MechanicRuleRequest req:request.getMechanicRules()){
            MechanicRule rule = init(request.getMechanic(), req);
            validateRequest(request.getMechanic(), req);
            repository.save(rule);
        }
    }

    /**
     * Inicializa un objeto MechanicDetail.
     * @param request - Item a registrar
     * @return - Retorna el objeto inicializado.
     */
    private MechanicRule init(Long mechanicId, MechanicRuleRequest request) {

        MechanicRule rule = new MechanicRule();
        rule.setMechanic(mechanicService.get(mechanicId));
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
    private void validateRequest(Long mechanicId, MechanicRuleRequest request) {

        String type = mechanicService.get(mechanicId).getType();

        if ( type.equals("R")){
            if (repository.findByMechanicAndStartRangeAndEndRange(mechanicId, request.getStartRange(), request.getEndRange()).isPresent()) {
                log.info(ConstantMessage.ITEM_ALREADY_ADDED);
                throw new BadRequestException(ConstantMessage.ITEM_ALREADY_ADDED);
            }
        } else if (type.equals("X")) {
            if (repository.findByMechanicAndStartRangeAndEndRangeAndFactor(mechanicId, request.getStartRange(), request.getEndRange(), request.getFactor()).isPresent()) {
                log.info(ConstantMessage.ITEM_ALREADY_ADDED);
                throw new BadRequestException(ConstantMessage.ITEM_ALREADY_ADDED);
            }
        } else if (type.equals("F")) {
            if (repository.findByMechanicAndFactor(mechanicId, request.getFactor()).isPresent()) {
                log.info(ConstantMessage.ITEM_ALREADY_ADDED);
                throw new BadRequestException(ConstantMessage.ITEM_ALREADY_ADDED);
            }
        }
    }
}
