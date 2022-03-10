package com.economysa.motor.app.security.service.impl;

import com.economysa.motor.app.security.controller.dto.UpdateUserDto;
import com.economysa.motor.app.security.controller.dto.UserDto;
import com.economysa.motor.app.security.entity.User;
import com.economysa.motor.app.security.repository.UserRepository;
import com.economysa.motor.app.security.service.UserService;
import com.economysa.motor.error.exception.BadRequestException;
import com.economysa.motor.error.exception.ResourceNotFoundException;
import com.economysa.motor.util.ConstantMessage;
import com.economysa.motor.util.MessageResponse;
import com.economysa.motor.util.UtilCore;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	@Autowired private PasswordEncoder encoder;

	private User init() {
		User user = new User();
		user.setCreationDate(UtilCore.UtilDate.fechaActual());
		user.setStatus(Boolean.TRUE);
		return user;
	}

	private User init(String email, UserDto dto) {
		User user = init();
		user = setData(user, dto);
		user.setEmail(dto.getEmail());
		user.setPassword(encoder.encode(dto.getPassword()));
		user.setCreationUser(get(email));
		return user;
	}

	private User setData(User user, UserDto dto) {
		user.setRole(dto.getRole());
		user.setName(dto.getName());
		user.setLastName(dto.getLastName());
		user.setPhone(dto.getPhone());

		return user;
	}

	private User setUpdateData(User user, UpdateUserDto dto) {
		user.setRole(dto.getRole());
		user.setName(dto.getName());
		user.setLastName(dto.getLastName());
		user.setPhone(dto.getPhone());

		return user;
	}

	@Override
	public Page<User> list(Pageable pageable) {
		return repository.find(pageable);
	}

	@Override
	public User 	get(Long id) {
		return repository.findById(id).orElseThrow(() -> {
			log.info("No User found for ID [ " + id + " ]");
			return new ResourceNotFoundException("No User found for ID [ " + id + " ]");
		});
	}

	@Override
	public User create(String email, UserDto dto) {
		validateEmail(dto.getEmail());
		return repository.save(init(email, dto));
	}

	@Override
	public User update(String email, Long id, UpdateUserDto dto) {
		User user = get(id);
		user = setUpdateData(user, dto);
		user.setUpdateUser(get(email));
		user.setUpdateDate(UtilCore.UtilDate.fechaActual());

		return repository.save(user);
	}

	@Override
	public MessageResponse delete(String email, Long id) {
		User user = get(email);
		user.setUpdateUser(get(email));
		user.setUpdateDate(UtilCore.UtilDate.fechaActual());
		user.setStatus(Boolean.FALSE);
		repository.save(user);

		return new MessageResponse(ConstantMessage.SUCCESSFUL_OPERATION);
	}

	@Override
	public User get(String email) {
		Optional<User> user = repository.findByEmail(email);
		if (!user.isPresent()) {
			log.info("Get ==> Not found {email = " + email + "}");
			throw new ResourceNotFoundException(ConstantMessage.USER_NOT_FOUND_EMAIL);
		}
		return user.get();
	}

	private void validateEmail(String email) {
		if (repository.findByEmail(email).isPresent()) {
			log.info("Trying to register an existent email [ " + email + " ]");
			throw new BadRequestException(ConstantMessage.USER_ALREADY_EXISTS);
		}
	}
}
