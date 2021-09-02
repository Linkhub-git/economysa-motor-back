package com.quickdev.base.app.security.service;

import com.quickdev.base.app.security.entity.User;

/**
 * @author QuickDev
 * @version 1.0
 */
public interface UserService {

	User get(String email);
}
