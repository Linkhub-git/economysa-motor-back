package com.economysa.motor.app.configuration.service.impl;

import com.economysa.motor.app.configuration.entity.ListPrice;
import com.economysa.motor.app.configuration.repository.ListPriceRepository;
import com.economysa.motor.app.configuration.service.ListPriceService;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ListPriceServiceImpl implements ListPriceService {

  @Autowired private ListPriceRepository repository;

  @Override
  public List<ListPrice> list() {
    return repository.findAll();
  }

  @Override
  public ListPrice get(Long id) {
    Optional<ListPrice> listPrice = repository.findById(id);
    if (listPrice.isEmpty()) {
      log.info("No ListPrice found for ID [ " + id + " ]");
      throw new ResourceNotFoundException("No ListPrice found for ID [ " + id + " ]");
    }
    return listPrice.get();
  }
}
