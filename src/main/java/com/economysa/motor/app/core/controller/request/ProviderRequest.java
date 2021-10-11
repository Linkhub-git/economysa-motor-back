package com.economysa.motor.app.core.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Proveedor Request", description = "Contiene la información necesaria para crear/actualizar un Proveedor")
public class ProviderRequest {

	@Size(max = 10)
	@ApiModelProperty(
			name = "id",
			value = "Identificador único por Proveedor",
			example = "000752",
			dataType = "String",
			required = true,
			position = 0
	)
	private String id;

	@NotNull
	@Size(min = 1, max = 50)
	@ApiModelProperty(
			name = "name",
			value = "Nombre del Proveedor",
			example = "CLOROX PERU S.A.",
			dataType = "String",
			required = true,
			position = 1
	)
	private String name;

	@NotNull
	@Size(min = 1, max = 20)
	@ApiModelProperty(
			name = "ruc",
			value = "RUC del Proveedor",
			example = "20100003946",
			dataType = "String",
			required = true,
			position = 2
	)
	private String ruc;
}
