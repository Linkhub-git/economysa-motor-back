package com.economysa.motor.app.core.service;

import com.economysa.motor.app.core.controller.dto.ProviderDto;
import com.economysa.motor.app.core.entity.Provider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProviderService {

	Provider init(ProviderDto dto);
	Page<Provider> list(Pageable pageable);
	List<Provider> search(String name);
	Provider get(Long id);
	void saveAll(List<Provider> items);
	Provider getByCode(String code);
}
