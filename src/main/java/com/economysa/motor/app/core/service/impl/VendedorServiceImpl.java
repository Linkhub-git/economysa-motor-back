package com.economysa.motor.app.core.service.impl;

import com.economysa.motor.app.core.entity.Vendedor;
import com.economysa.motor.app.core.repository.VendedorRepository;
import com.economysa.motor.app.core.service.VendedorService;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class VendedorServiceImpl implements VendedorService {

	@Autowired private VendedorRepository repository;

	@Override
	public Page<Vendedor> list(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Vendedor get(String codigo) {
		Optional<Vendedor> vendedor = repository.findByCodigo(codigo);
		if (!vendedor.isPresent()) {
			log.info("No vendedor con codigo: " + codigo);
			throw new ResourceNotFoundException("No existe vendedor con id: " + codigo);
		}
		return vendedor.get();
	}

	@Override
	public Vendedor create(Vendedor vendedor) {
		return repository.save(vendedor);
	}

	@Override
	public Vendedor update(Vendedor vendedor) {
		return repository.save(vendedor);
	}

	@Override
	public String delete(String codigo) {
		Vendedor vendedor = get(codigo);
		repository.delete(vendedor);

		return "Eliminado correctamente";
	}
}
