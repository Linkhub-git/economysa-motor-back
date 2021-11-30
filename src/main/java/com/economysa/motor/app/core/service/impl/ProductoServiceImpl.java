package com.economysa.motor.app.core.service.impl;

import com.economysa.motor.app.core.entity.Producto;
import com.economysa.motor.app.core.repository.ProductoRepository;
import com.economysa.motor.app.core.service.ProductoService;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class ProductoServiceImpl implements ProductoService {

	@Autowired private ProductoRepository repository;

	@Override
	public Page<Producto> list(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Producto get(String id) {
		Optional<Producto> producto = repository.findById(id);
		if (!producto.isPresent()) {
			log.info("No producto con id: " + id);
			throw new ResourceNotFoundException("No existe el producto con id: " + id);
		}
		return producto.get();
	}

	@Override
	public Producto create(Producto producto) {
		return repository.save(producto);
	}

	@Override
	public Producto update(Producto producto) {
		return repository.save(producto);
	}

	@Override
	public String delete(String id) {
		Producto producto = get(id);
		repository.delete(producto);

		return "Eliminado correctamente";
	}
}
