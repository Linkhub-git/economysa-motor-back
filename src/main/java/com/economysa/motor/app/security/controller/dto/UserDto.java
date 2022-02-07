package com.economysa.motor.app.security.controller.dto;

import com.economysa.motor.util.ConstantMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	@NotBlank(message = ConstantMessage.NOT_BLANK_EMAIL)
	@Size(min = 1, max = 50, message = ConstantMessage.INVALID_SIZE_EMAIL)
	@Email(message = ConstantMessage.INVALID_EMAIL)
	private String email;

	@NotBlank(message = ConstantMessage.NOT_BLANK_PASSWORD)
	@Size(min = 1, max = 256, message = ConstantMessage.INVALID_SIZE_PASSWORD)
	private String password;

	@NotBlank(message = ConstantMessage.NOT_BLANK_ROLE)
	@Size(min = 1, max = 10, message = ConstantMessage.INVALID_SIZE_ROLE)
	private String role;

	@NotBlank(message = ConstantMessage.NOT_BLANK_NAME)
	@Size(min = 1, max = 100, message = ConstantMessage.INVALID_SIZE_NAME)
	private String name;

	@NotBlank(message = ConstantMessage.NOT_BLANK_LAST_NAME)
	@Size(min = 1, max = 100, message = ConstantMessage.INVALID_SIZE_LAST_NAME)
	private String lastName;

	@Size(min = 9, max = 9, message = ConstantMessage.INVALID_SIZE_PHONE)
	private String phone;
}
