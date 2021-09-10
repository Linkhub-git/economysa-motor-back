package com.economysa.motor.app.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {

	@Id
	@NotNull
	@Size(max = 10)
	private String codigo;

	@NotNull
	@Size(max = 50)
	private String nombreCliente;

	@Size(max = 10)
	private String codigoPadre;

	@Size(max = 20)
	private String razonSocial;

	@NotNull
	@Size(max = 10)
	private String tipoDoc;

	@NotNull
	@Size(max = 10)
	private String nroDoc;

	@NotNull
	@Size(max = 10)
	private String celular;

	@NotNull
	@Email
	@Size(max = 30)
	private String correo;

	@NotNull
	private BigDecimal limiteCred;

	@NotNull
	private BigDecimal limiteDoc;

	@Size(max = 50)
	private String direccionFiscal;

	@NotNull
	@Size(max = 50)
	private String ubigeo;

	@NotNull
	private Boolean estado;
}
