package com.economysa.motor.app.core.entity;

import com.economysa.motor.util.ConstantMessage;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {

	@Column(name = "creation_user")
	@NotNull
	@Size(min = 5, max = 50)
	@ApiModelProperty(
			name = "creationUser",
			value = "Usuario del sistema que creó el registro",
			example = "jcieza90@gmail.com",
			dataType = "String",
			required = true
	)
	private String creationUser;

	@Column(name = "creation_date")
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@ApiModelProperty(
			name = "creationDate",
			value = "Fecha del sistema en la cual se creó el registro",
			example = "2021-10-10T16:15:01.074Z",
			dataType = "Date",
			required = true
	)
	private Date creationDate;

	@Column(name = "update_user")
	@Size(min = 5, max = 50)
	@ApiModelProperty(
			name = "updateUser",
			value = "Usuario del sistema que realiza alguna actualización en el registro",
			example = "jcieza90@gmail.com",
			dataType = "String"
	)
	private String updateUser;

	@Column(name = "update_date")
	@Temporal(TemporalType.TIMESTAMP)
	@ApiModelProperty(
			name = "updateDate",
			value = "Fecha del sistema en la cual se realiza una actualización en el registro",
			example = "2021-10-10T16:15:01.074Z",
			dataType = "Date"
	)
	private Date updateDate;

	@Column(name = "_status")
	@NotNull
	@ApiModelProperty(
			name = "status",
			value = "Estado del registro en el sistema",
			example = "true|false",
			dataType = "Boolean"
	)
	private Boolean status;

	@Transient
	@ApiModelProperty(
			name = "statusText",
			value = "Estado en formato texto indicando el estado actual del registro en el sistema",
			example = "Activo|Inactivo",
			dataType = "String"
	)
	private String statusText;

	public String getStatusText() {
		return status ? ConstantMessage.ACTIVE: ConstantMessage.INACTIVE;
	}
}
