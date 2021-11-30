package com.economysa.motor.app.core.service;

import com.economysa.motor.app.core.entity.Vendedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VendedorService {

	Page<Vendedor> list(Pageable pageable);
	Vendedor get(String codigo);
	Vendedor create(Vendedor vendedor);
	Vendedor update(Vendedor vendedor);
	String delete(String codigo);
}
