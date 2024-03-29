package com.economysa.motor.app.security.controller;

import com.economysa.motor.app.security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QuickDev
 * @version 1.0
 */
@RestController
@RequestMapping("/api/v1/secured/user")
@AllArgsConstructor
public class UserController {

	private final UserService service;
}
