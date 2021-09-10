package com.economysa.motor.app.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Proveedor {

	@Id
	@Size(max = 10)
	private String id;

	@NotNull
	@Size(max = 50)
	private String nombre;

	@NotNull
	@Size(max = 20)
	private String ruc;
}
