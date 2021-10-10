package com.economysa.motor.app.core.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderRequest {

	@Size(max = 10)
	private String id;

	@NotNull
	@Size(min = 1, max = 50)
	private String name;

	@NotNull
	@Size(min = 1, max = 20)
	private String ruc;
}
