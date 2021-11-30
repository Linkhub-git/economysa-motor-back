package com.economysa.motor.app.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Promocion {

	@Id
	@NotNull
	@Size(max = 10)
	private String idMecanica;

	@NotNull
	@Size(max = 10)
	private String idProveedor;

	@NotNull
	private Long tipoPromocion;

	@NotNull
	private Long modalidadPromocion;

	@NotNull
	@Size(max = 10)
	private String unidadPromocion;

	@NotNull
	private BigDecimal factor;

	@NotNull
	private BigDecimal dscto;

	@NotNull
	private BigDecimal cantidad;

	@NotNull
	@Size(max = 20)
	private String listaPrecio;

	@NotNull
	private BigDecimal min;

	@NotNull
	private BigDecimal max;

	@NotNull
	private BigDecimal cantidadMaxBonif;

	@NotNull
	@Size(max = 20)
	private String cantMaxPdv;

	private Date fechaIni;

	@NotNull
	private String horaIni;

	private Date fechaFin;

	@NotNull
	private String horaFin;

	@NotNull
	private BigDecimal tope;

	@NotNull
	@Size(max = 100)
	private String observacion;
}
