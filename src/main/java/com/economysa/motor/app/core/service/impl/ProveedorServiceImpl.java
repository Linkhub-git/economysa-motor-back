package com.economysa.motor.app.core.service.impl;

import com.economysa.motor.app.core.entity.Proveedor;
import com.economysa.motor.app.core.repository.ProveedorRepository;
import com.economysa.motor.app.core.service.ProveedorService;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class ProveedorServiceImpl implements ProveedorService {

	@Autowired private ProveedorRepository repository;

	@Override
	public Page<Proveedor> list(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Proveedor get(String id) {
		Optional<Proveedor> proveedor = repository.findById(id);
		if (!proveedor.isPresent()) {
			log.info("No proveedor con id: " + id);
			throw new ResourceNotFoundException("No existe proveedor con id: " + id);
		}
		return proveedor.get();
	}

	@Override
	public Proveedor create(Proveedor proveedor) {
		return repository.save(proveedor);
	}

	@Override
	public Proveedor update(Proveedor proveedor) {
		return repository.save(proveedor);
	}

	@Override
	public String delete(String id) {
		Proveedor proveedor = get(id);
		repository.delete(proveedor);

		return "Eliminado correctamente";
	}
}
