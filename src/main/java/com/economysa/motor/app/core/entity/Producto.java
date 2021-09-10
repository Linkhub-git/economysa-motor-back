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
public class Producto {

	@Id
	@NotNull
	@Size(max = 10)
	private String id;

	@NotNull
	@Size(max = 50)
	private String nombre;

	@NotNull
	@Size(max = 20)
	private String purchasePackaging;

	@NotNull
	private BigDecimal masterStockAmount;

	@NotNull
	private BigDecimal salesPackaging;

	@NotNull
	private BigDecimal stockAmount;

	@NotNull
	@Size(max = 10)
	private String idProveedor;
	
	private BigDecimal stock;

	private BigDecimal precioBase;

	@NotNull
	private BigDecimal margen;

	@NotNull
	private BigDecimal precioFinal;

	@NotNull
	@Size(max = 50)
	private String denominacionCorta;

	@NotNull
	@Size(max = 20)
	private String unidadVenta;

	@NotNull
	@Size(max = 20)
	private String categoria;

	@NotNull
	@Size(max = 20)
	private String subcategoria;

	@NotNull
	@Size(max = 20)
	private String master;

	private Date fechaVencimiento;

	@NotNull
	private BigDecimal precioVenta;

	@NotNull
	private BigDecimal precioCompra;

	@NotNull
	@Size(max = 20)
	private String codigoEan;

	@NotNull
	private BigDecimal peso;

	@NotNull
	private BigDecimal dimension;

	@NotNull
	private Boolean suspendidoCompra;

	@NotNull
	private Boolean suspendidoVenta;

	@NotNull
	private Boolean afecto;

	@NotNull
	private BigDecimal stockActual;

	@NotNull
	private BigDecimal stockReserva;

	@NotNull
	@Size(max = 10)
	private String codigoOrigenProveedor;

	@Size(max = 10)
	private String codigoSunat;

	@Size(max = 50)
	private String sucursal;

	@NotNull
	private Boolean estado;
}
