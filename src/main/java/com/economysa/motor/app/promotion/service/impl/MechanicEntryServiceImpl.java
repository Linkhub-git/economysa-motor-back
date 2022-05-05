package com.economysa.motor.app.promotion.service.impl;

import com.economysa.motor.app.configuration.service.EntryService;
import com.economysa.motor.app.configuration.service.ListPriceService;
import com.economysa.motor.app.promotion.controller.request.MechanicEntryRequest;
import com.economysa.motor.app.promotion.entity.MechanicEntry;
import com.economysa.motor.app.promotion.repository.MechanicEntryRepository;
import com.economysa.motor.app.promotion.service.MechanicEntryService;
import com.economysa.motor.error.exception.BadRequestException;
import com.economysa.motor.util.ConstantMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class MechanicEntryServiceImpl implements MechanicEntryService {

  @Autowired private MechanicEntryRepository repository;
  @Autowired private EntryService entryService;
  @Autowired private ListPriceService listPriceService;

  @Override
  public List<MechanicEntry> listByMechanic(Long idMechanic) {
    List<MechanicEntry> result = new ArrayList<>();
    List<MechanicEntry> items = repository.findByMechanic(idMechanic);
    for (MechanicEntry e : items) {
      if (e.getType().equals(ConstantMessage.MECHANIC_ENTRY_TYPE_LIST)) {
        e.setEntryName(listPriceService.get(e.getIdentifier()).getFormatted());
      } else {
        e.setEntryName(entryService.get(e.getIdentifier()).getDescription());
      }
      result.add(e);
    }
    log.info(result);
    return result;
  }

  @Override
  public MechanicEntry add(MechanicEntryRequest request) {
    validateEntry(request);
    MechanicEntry entry = new MechanicEntry();
    entry.setMechanic(request.getMechanic());
    entry.setType(validateType(request.getType()));
    entry.setIdentifier(request.getIdentifier());

    return repository.save(entry);
  }

  private void validateEntry(MechanicEntryRequest request) {
    if (repository.findByMechanicAndTypeAndIdentifier(request.getMechanic(),
          request.getType(), request.getIdentifier()).isPresent()) {
      log.info("Entry already added");
      throw new BadRequestException("El tiem ya ha sido agregado");
    }
  }

  private String validateType(String type) {
    if (type.equals(ConstantMessage.MECHANIC_ENTRY_TYPE_LIST)
          || type.equals(ConstantMessage.MECHANIC_ENTRY_TYPE_GIRO)) {
      return type;
    } else {
      throw new IllegalArgumentException("Invalid Type value [ " + type + " ]");
    }
  }
}
