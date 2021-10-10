package com.economysa.motor.app.core.service;

import com.economysa.motor.app.core.controller.request.ProviderRequest;
import com.economysa.motor.app.core.entity.Provider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProviderService {

	Page<Provider> list(Pageable pageable);
	Provider get(String id);
	Provider create(String creationUser, ProviderRequest request);
	Provider update(String updateUser, String id, ProviderRequest request);
	Provider delete(String updateUser, String id);
}
