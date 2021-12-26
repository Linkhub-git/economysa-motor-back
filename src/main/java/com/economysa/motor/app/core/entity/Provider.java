package com.economysa.motor.app.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(
			name = "id",
			value = "Identificador único por Proveedor",
			example = "1000",
			dataType = "Long",
			required = true,
			position = 0
	)
	private Long id;

	@Column(name = "_name")
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

	@Column(name = "_ruc")
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
