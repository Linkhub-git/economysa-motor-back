package com.economysa.motor.app.core.entity;

import com.economysa.motor.util.ConstantMessage;
import io.swagger.annotations.ApiModel;
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

	@NotNull
	@Size(min = 5, max = 50)
	@Column(name = "creation_user")
	@ApiModelProperty(
			name = "creationUser",
			value = "Usuario del sistema que creó el registro",
			example = "jcieza90@gmail.com",
			dataType = "String",
			required = true
	)
	private String creationUser;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date")
	@ApiModelProperty(
			name = "creationDate",
			value = "Fecha del sistema en la cual se creó el registro",
			example = "2021-10-10T16:15:01.074Z",
			dataType = "Date",
			required = true
	)
	private Date creationDate;

	@Size(min = 5, max = 50)
	@Column(name = "update_user")
	@ApiModelProperty(
			name = "updateUser",
			value = "Usuario del sistema que realiza alguna actualización en el registro",
			example = "jcieza90@gmail.com",
			dataType = "String"
	)
	private String updateUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date")
	@ApiModelProperty(
			name = "updateDate",
			value = "Fecha del sistema en la cual se realiza una actualización en el registro",
			example = "2021-10-10T16:15:01.074Z",
			dataType = "Date"
	)
	private Date updateDate;

	@NotNull
	@Column(name = "_status")
	private Boolean status;

	@Transient
	private String statusText;

	public String getStatusText() {
		return status ? ConstantMessage.ACTIVE: ConstantMessage.INACTIVE;
	}
}
