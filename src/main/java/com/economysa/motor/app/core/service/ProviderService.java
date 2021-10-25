package com.economysa.motor.app.core.service;

import com.economysa.motor.app.core.controller.request.ProviderRequest;
import com.economysa.motor.app.core.entity.Provider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProviderService {

	Page<Provider> list(Pageable pageable);
	List<Provider> search(String name);
	Provider get(Long id);
	Provider create(String creationUser, ProviderRequest request);
	Provider update(String updateUser, Long id, ProviderRequest request);
	Provider delete(String updateUser, Long id);
}
