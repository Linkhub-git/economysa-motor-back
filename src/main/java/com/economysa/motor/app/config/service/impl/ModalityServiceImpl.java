package com.economysa.motor.app.config.service.impl;

import com.economysa.motor.app.config.entity.Modality;
import com.economysa.motor.app.config.repository.ModalityRepository;
import com.economysa.motor.app.config.service.ModalityService;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import com.economysa.motor.util.ConstantMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ModalityServiceImpl implements ModalityService {

  @Autowired private ModalityRepository repository;

  @Override
  public List<Modality> list() {
    return repository.findAll();
  }

  @Override
  public Modality get(Long id) {
    Optional<Modality> modality = repository.findById(id);
    if (!modality.isPresent()) {
      log.info("No Modality entity for ID [ " + id + " ]");
      throw new ResourceNotFoundException(ConstantMessage.MODALITY_NOT_FOUND);
    }
    return modality.get();
  }
}
