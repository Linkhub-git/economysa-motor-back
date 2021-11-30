package com.economysa.motor.app.core.service.impl;

import com.economysa.motor.app.core.entity.DireccionEntrega;
import com.economysa.motor.app.core.repository.DireccionEntregaRepository;
import com.economysa.motor.app.core.service.DireccionEntregaService;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class DireccionEntregaServiceImpl implements DireccionEntregaService {

	@Autowired private DireccionEntregaRepository repository;

	@Override
	public Page<DireccionEntrega> list(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public DireccionEntrega get(String codigo) {
		Optional<DireccionEntrega> direccionEntrega = repository.findByCodigo(codigo);
		if (!direccionEntrega.isPresent()) {
			log.info("No direccionEntrega con codigo: " + codigo);
			throw new ResourceNotFoundException("No existe diredcionEntrega con codigo: " + codigo);
		}
		return direccionEntrega.get();
	}

	@Override
	public DireccionEntrega create(DireccionEntrega direccionEntrega) {
		return repository.save(direccionEntrega);
	}

	@Override
	public DireccionEntrega update(DireccionEntrega direccionEntrega) {
		return repository.save(direccionEntrega);
	}

	@Override
	public String delete(String codigo) {
		DireccionEntrega direccionEntrega = get(codigo);
		repository.delete(direccionEntrega);

		return "Eliminado correctamente";
	}
}
