package com.economysa.motor.app.core.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel(value = "Vendedor", description = "Vendedores")
public class Vendedor {

	@Id
	@NotNull
	@Size(max = 10)
	private String codigo;

	@NotNull
	@Size(max = 50)
	private String nombres;

	@NotNull
	@Size(max = 10)
	private String telefono;

	@NotNull
	@Email
	@Size(max = 20)
	private String correo;

	@NotNull
	@Size(max = 10)
	private String jvta;

	@NotNull
	@Size(max = 50)
	private String jefeVenta;

	@NotNull
	@Size(max = 10)
	private String codSup;

	@NotNull
	@Size(max = 20)
	private String supervisor;
}
