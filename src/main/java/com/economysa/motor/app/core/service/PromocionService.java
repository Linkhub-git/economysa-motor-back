package com.economysa.motor.app.core.service;

import com.economysa.motor.app.core.entity.Promocion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PromocionService {

	Page<Promocion> list(Pageable pageable);
	Promocion get(String id);
	Promocion create(Promocion promocion);
	Promocion update(Promocion promocion);
	String delete(String id);
}
