package com.economysa.motor.app.security.entity;

import com.economysa.motor.util.ConstantMessage;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "tsegu_user")
public class User {

	@Id
	private Long id;

	@NotBlank
	@Size(max = 50)
	@Email
	@Column(name = "_email")
	private String email;

	@NotBlank
	@Size(max = 256)
	@JsonIgnore
	@Column(name = "_password")
	private String password;

	@NotBlank
	@Size(max = 10)
	@Column(name = "_role")
	private String role;

	@NotBlank
	@Size(max = 100)
	@Column(name = "_name")
	private String name;

	@NotBlank
	@Size(max = 100)
	@Column(name = "last_name")
	private String lastName;

	@Size(max = 9)
	@Column(name = "_phone")
	private String phone;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	@Column(name = "creation_date")
	private Date creationDate;

	@NotNull
	@Column(name = "_status")
	private Boolean status;

	@Transient
	private String statusText;

	public String getStatusText() {
		return status ? ConstantMessage.ACTIVE : ConstantMessage.INACTIVE;
	}
}
