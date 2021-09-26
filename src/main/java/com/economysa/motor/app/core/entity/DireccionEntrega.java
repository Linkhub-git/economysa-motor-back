package com.economysa.motor.app.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DireccionEntrega {

	@Id
	@NotNull
	@Size(max = 10)
	private String codDireccion;

	@NotNull
	@Size(max = 10)
	private String codCli;

	@NotNull
	@Size(max = 50)
	private String direccionEntrega;

	@NotNull
	@Size(max = 20)
	private String ruta;

	@NotNull
	@Size(max = 10)
	private String modulo;

	@NotNull
	@Size(max = 50)
	private String ubigeo;

	@NotNull
	@Size(max = 20)
	private String giro;

	@NotNull
	@Size(max = 20)
	private String latitud;

	@NotNull
	@Size(max = 20)
	private String longitud;

	@NotNull
	@Size(max = 30)
	private String secuenciaVisita;

	@NotNull
	@Size(max = 20)
	private String horarioVent1;

	@NotNull
	@Size(max = 20)
	private String horarioVent2;

	@NotNull
	private Boolean estado;

	@Transient
	private String estadoTexto;

	public String getEstadoTexto() {
		return estado? "Activo" : "Inactivo";
	}
}
