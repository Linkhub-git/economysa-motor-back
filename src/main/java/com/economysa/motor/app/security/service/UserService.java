package com.economysa.motor.app.security.service;

import com.economysa.motor.app.security.controller.dto.UpdateUserDto;
import com.economysa.motor.app.security.controller.dto.UserDto;
import com.economysa.motor.app.security.entity.User;
import com.economysa.motor.util.MessageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author QuickDev
 * @version 1.0
 */
public interface UserService {

	Page<User> list(Pageable pageable);
	User get(Long id);
	User get(String email);
	User create(String email, UserDto dto);
	User update(String email, Long id, UpdateUserDto dto);
	MessageResponse delete(String email, Long id);
}
