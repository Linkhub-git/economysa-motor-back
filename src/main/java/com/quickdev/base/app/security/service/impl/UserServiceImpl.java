package com.quickdev.base.app.security.service.impl;

import com.quickdev.base.app.security.entity.User;
import com.quickdev.base.app.security.repository.UserRepository;
import com.quickdev.base.app.security.service.UserService;
import com.quickdev.base.error.exception.ResourceNotFoundException;
import com.quickdev.base.util.ConstantMessage;
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
public class UserServiceImpl implements UserService {

	@Autowired private UserRepository repository;

	@Override
	public User get(String email) {
		log.info("Get ==> {email = " + email + "}");
		Optional<User> user = repository.findByEmail(email);
		if (!user.isPresent()) {
			log.info("Get ==> Not found {email = " + email + "}");
			throw new ResourceNotFoundException(ConstantMessage.USER_NOT_FOUND_EMAIL);
		}
		log.info("Get ==> response = " + user.get());
		return user.get();
	}
}
