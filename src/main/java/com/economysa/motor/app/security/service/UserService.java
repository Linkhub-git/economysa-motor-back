package com.economysa.motor.app.security.service;

import com.economysa.motor.app.security.entity.User;

/**
 * @author QuickDev
 * @version 1.0
 */
public interface UserService {

	User get(String email);
}
