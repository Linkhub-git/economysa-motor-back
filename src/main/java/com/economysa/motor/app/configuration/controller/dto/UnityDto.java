package com.economysa.motor.app.configuration.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnityDto {

	@NotNull
	@Size(min = 1, max = 5)
	private String code;

	@NotNull
	@Size(min = 1, max = 20)
	private String name;
}
