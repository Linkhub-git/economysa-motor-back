package com.economysa.motor.app.core.service;

import com.economysa.motor.app.core.entity.DireccionEntrega;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DireccionEntregaService {

	Page<DireccionEntrega> list(Pageable pageable);
	DireccionEntrega get(String codigo);
	DireccionEntrega create(DireccionEntrega direccionEntrega);
	DireccionEntrega update(DireccionEntrega direccionEntrega);
	String delete(String codigo);
}
