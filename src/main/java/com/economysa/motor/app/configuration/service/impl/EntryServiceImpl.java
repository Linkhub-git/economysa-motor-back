package com.economysa.motor.app.configuration.service.impl;

import com.economysa.motor.app.configuration.entity.Entry;
import com.economysa.motor.app.configuration.repository.EntryRepository;
import com.economysa.motor.app.configuration.service.EntryService;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class EntryServiceImpl implements EntryService {

  @Autowired
  private EntryRepository repository;

  @Override
  public List<Entry> listByListPrice(Long idListPrice) {
    return repository.findByListPrice(idListPrice);
  }

  @Override
  public List<Entry> search(String query) {
    return repository.findByDescription(query);
  }

  @Override
  public Entry get(Long id) {
    Optional<Entry> entry = repository.findById(id);
    if (!entry.isPresent()) {
      log.info("No Entry for ID [ " + id + " ]");
      throw new ResourceNotFoundException("No Entry for ID [ " + id + " ]");
    }
    return entry.get();
  }
}
