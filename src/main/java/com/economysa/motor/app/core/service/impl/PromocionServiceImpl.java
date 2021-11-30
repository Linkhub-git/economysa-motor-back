package com.economysa.motor.app.core.service.impl;

import com.economysa.motor.app.core.entity.Promocion;
import com.economysa.motor.app.core.repository.PromocionRepository;
import com.economysa.motor.app.core.service.PromocionService;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class PromocionServiceImpl implements PromocionService {

	@Autowired private PromocionRepository repository;

	@Override
	public Page<Promocion> list(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Promocion get(String id) {
		Optional<Promocion> promocion = repository.findById(id);
		if (!promocion.isPresent()) {
			log.info("No promocion con id: " + id);
			throw new ResourceNotFoundException("No existe promocion con id: " + id);
		}
		return promocion.get();
	}

	@Override
	public Promocion create(Promocion promocion) {
		return repository.save(promocion);
	}

	@Override
	public Promocion update(Promocion promocion) {
		return repository.save(promocion);
	}

	@Override
	public String delete(String id) {
		Promocion promocion = get(id);
		repository.delete(promocion);

		return "Eliminado correctamente";
	}
}
