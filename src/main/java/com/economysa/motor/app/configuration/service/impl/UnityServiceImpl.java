package com.economysa.motor.app.configuration.service.impl;

import com.economysa.motor.app.configuration.controller.dto.UnityDto;
import com.economysa.motor.app.configuration.entity.Unity;
import com.economysa.motor.app.configuration.repository.UnityRepository;
import com.economysa.motor.app.configuration.service.UnityService;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@AllArgsConstructor
public class UnityServiceImpl implements UnityService {

	private final UnityRepository repository;

	@Override
	public Unity init(UnityDto dto) {
		Unity unity = new Unity();
		unity.setCode(dto.getCode());
		unity.setName(dto.getName());
		return unity;
	}

	@Transactional
	@Override
	public void saveAll(List<Unity> items) {
		repository.saveAll(items);
	}

	@Override
	public Unity getByCode(String code) {
		return repository.findByCode(code);
	}

	@Override
	public Page<Unity> list(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Unity get(Long id) {
		Optional<Unity> unity = repository.findById(id);
		if (unity.isEmpty()) {
			log.info("No Unity found for ID [ " + id + " ]");
			throw new ResourceNotFoundException("No Unity found for ID [ " + id + " ]");
		}
		return unity.get();
	}
}
