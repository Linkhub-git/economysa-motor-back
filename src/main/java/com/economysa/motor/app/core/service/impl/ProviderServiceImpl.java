package com.economysa.motor.app.core.service.impl;

import com.economysa.motor.app.core.controller.dto.ProviderDto;
import com.economysa.motor.app.core.entity.Provider;
import com.economysa.motor.app.core.repository.ProviderRepository;
import com.economysa.motor.app.core.service.ProviderService;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import com.economysa.motor.util.ConstantMessage;
import com.economysa.motor.util.UtilCore;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ProviderServiceImpl implements ProviderService {

	@Autowired private ProviderRepository repository;

	private Provider init() {
		Provider provider = new Provider();
		provider.setCreationDate(UtilCore.UtilDate.fechaActual());
		provider.setStatus(Boolean.TRUE);
		return provider;
	}

	private Provider init(String creationUser, ProviderDto request) {
		Provider provider = init();
		provider.setName(request.getName());
		provider.setRuc(request.getRuc());
		provider.setCreationUser(creationUser);
		return provider;
	}

	@Override
	public Page<Provider> list(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public List<Provider> search(String name) {
		return repository.find(name);
	}

	@Override
	public Provider get(Long id) {
		Optional<Provider> provider = repository.findById(id);
		if (!provider.isPresent()) {
			log.info("No Provider entity for ID [ " + id + " ]");
			throw new ResourceNotFoundException(ConstantMessage.PROVIDER_NOT_FOUND);
		}
		return provider.get();
	}

	@Override
	public Provider create(String creationUser, ProviderDto request) {
		Provider provider = init(creationUser, request);

		return repository.save(provider);
	}

	@Override
	public Provider update(String updateUser, Long id, ProviderDto request) {
		Provider provider = get(id);
		provider.setName(request.getName());
		provider.setRuc(request.getRuc());
		provider.setUpdateUser(updateUser);
		provider.setUpdateDate(UtilCore.UtilDate.fechaActual());

		return repository.save(provider);
	}

	@Override
	public Provider delete(String updateUser, Long id) {
		Provider provider = get(id);
		provider.setStatus(Boolean.FALSE);
		provider.setUpdateUser(updateUser);
		provider.setUpdateDate(UtilCore.UtilDate.fechaActual());

		return repository.save(provider);
	}
}
