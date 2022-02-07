package com.economysa.motor.app.configuration.service;

import com.economysa.motor.app.configuration.controller.dto.UnityDto;
import com.economysa.motor.app.configuration.entity.Unity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UnityService {

	Page<Unity> list(Pageable pageable);
	Unity get(Long id);
	Unity init(UnityDto dto);
	void saveAll(List<Unity> items);
}
