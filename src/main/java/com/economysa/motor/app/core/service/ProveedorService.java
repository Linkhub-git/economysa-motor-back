package com.economysa.motor.app.core.service;

import com.economysa.motor.app.core.entity.Proveedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProveedorService {

	Page<Proveedor> list(Pageable pageable);
	Proveedor get(String id);
	Proveedor create(Proveedor proveedor);
	Proveedor update(Proveedor proveedor);
	String delete(String id);
}
