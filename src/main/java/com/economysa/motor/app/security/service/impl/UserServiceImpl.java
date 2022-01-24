package com.economysa.motor.app.security.service.impl;

import com.economysa.motor.app.security.entity.User;
import com.economysa.motor.app.security.repository.UserRepository;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import com.economysa.motor.util.ConstantMessage;
import com.economysa.motor.app.security.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author QuickDev
 * @version 1.0
 */
@Service
@Log4j2
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository repository;

	@Override
	public User get(String email) {
		Optional<User> user = repository.findByEmail(email);
		if (!user.isPresent()) {
			log.info("Get ==> Not found {email = " + email + "}");
			throw new ResourceNotFoundException(ConstantMessage.USER_NOT_FOUND_EMAIL);
		}
		return user.get();
	}
}
