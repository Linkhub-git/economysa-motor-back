package com.economysa.motor.app.core.service;

import com.economysa.motor.app.core.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductoService {

	Page<Producto> list(Pageable pageable);
	Producto get(String id);
	Producto create(Producto producto);
	Producto update(Producto producto);
	String delete(String id);
}
