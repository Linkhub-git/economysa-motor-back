package com.economysa.motor.app.core.service;

import com.economysa.motor.app.core.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteService {

	Page<Cliente> list(Pageable pageable);
	Cliente get(String codigo);
	Cliente create(Cliente cliente);
	Cliente update(Cliente cliente);
	String delete(String codigo);
}
