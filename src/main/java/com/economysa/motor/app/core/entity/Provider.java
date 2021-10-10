package com.economysa.motor.app.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tcore_provider")
@ApiModel(value = "Proveedor", description = "Define a un proveedor de Economysa")
public class Provider extends BaseEntity {

	@Id
	@Size(max = 10)
	@Column(name = "id", updatable = false, unique = true)
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
	@Column(name = "_name")
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
	@Column(name = "_ruc")
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
