package com.economysa.motor.app.configuration.service;

import com.economysa.motor.app.configuration.entity.Entry;

import java.util.List;

public interface EntryService {

  List<Entry> listByListPrice(Long idListPrice);
  List<Entry> search(String query);
  Entry get(Long id);
}
