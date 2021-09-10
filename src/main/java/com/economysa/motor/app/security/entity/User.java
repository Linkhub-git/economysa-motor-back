package com.economysa.motor.app.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author QuickDev
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel(value = "Usuario", description = "Usuario del sistema")
public class User {

	@Id
	@ApiModelProperty(
			name = "id",
			value = "Identificador único",
			example = "1000",
			dataType = "Long",
			required = true,
			position = 0)
	private Long id;

	@NotBlank
	@Size(max = 50)
	@Email
	@ApiModelProperty(
			name = "email",
			value = "Correo electrónico",
			example = "jcieza90@gmail.com",
			dataType = "String",
			required = true,
			position = 1)
	private String email;

	@NotBlank
	@Size(max = 256)
	@JsonIgnore
	@ApiModelProperty(
			name = "password",
			value = "Contraseña",
			example = "123456",
			dataType = "String",
			required = true,
			position = 2)
	private String password;

	@NotBlank
	@Size(max = 10)
	@ApiModelProperty(
			name = "role",
			value = "Rol del usuario",
			example = "app",
			dataType = "String",
			required = true,
			position = 3)
	private String role;

	@NotBlank
	@Size(max = 100)
	@ApiModelProperty(
			name = "name",
			value = "Nombre del usuario",
			example = "Juan Jose",
			dataType = "String",
			required = true,
			position = 4)
	private String name;

	@NotBlank
	@Size(max = 100)
	@ApiModelProperty(
			name = "lastName",
			value = "Apellido del usuario",
			example = "Perez Perez",
			dataType = "String",
			required = true,
			position = 5)
	private String lastName;

	@Size(max = 9)
	@ApiModelProperty(
			name = "phone",
			value = "Teléfono del usuario",
			example = "987654321",
			dataType = "String",
			required = false,
			position = 6)
	private String phone;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	@ApiModelProperty(
			name = "creationDate",
			value = "Fecha creación",
			example = "01-07-1990",
			dataType = "Date",
			required = true,
			position = 7)
	private Date creationDate;

	@NotNull
	@ApiModelProperty(
			name = "status",
			value = "Estado del registro",
			example = "true",
			dataType = "Boolean",
			required = true,
			position = 8)
	private Boolean status;
}
