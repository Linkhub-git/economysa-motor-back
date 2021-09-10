package com.economysa.motor.app.core.service.impl;

import com.economysa.motor.app.core.entity.Cliente;
import com.economysa.motor.app.core.repository.ClienteRepository;
import com.economysa.motor.app.core.service.ClienteService;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class ClienteServiceImpl implements ClienteService {

	@Autowired private ClienteRepository repository;

	@Override
	public Page<Cliente> list(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Cliente get(String codigo) {
		Optional<Cliente> cliente = repository.findByCodigo(codigo);
		if (!cliente.isPresent()) {
			log.info("No cliente con codigo: " + codigo);
			throw new ResourceNotFoundException("No existe el cliente con codigo: " + codigo);
		}
		return cliente.get();
	}

	@Override
	public Cliente create(Cliente cliente) {
		return repository.save(cliente);
	}

	@Override
	public Cliente update(Cliente cliente) {
		return repository.save(cliente);
	}

	@Override
	public String delete(String codigo) {
		Cliente cliente = get(codigo);
		repository.delete(cliente);
		return "Eliminado correctamente";
	}
}
