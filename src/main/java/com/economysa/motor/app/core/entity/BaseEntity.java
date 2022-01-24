package com.economysa.motor.app.core.entity;

import com.economysa.motor.util.ConstantMessage;
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
	private String creationUser;

	@Column(name = "creation_date")
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@Column(name = "update_user")
	@Size(min = 5, max = 50)
	private String updateUser;

	@Column(name = "update_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	@Column(name = "_status")
	@NotNull
	private Boolean status;

	@Transient
	private String statusText;

	public String getStatusText() {
		return status ? ConstantMessage.ACTIVE: ConstantMessage.INACTIVE;
	}
}
