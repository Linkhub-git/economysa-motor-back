package com.economysa.motor.app.core.entity;

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
@Entity
@Table(name = "tcore_provider")
public class Provider {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "_code")
	@NotNull
	@Size(min = 1, max = 10)
	private String code;

	@Column(name = "_name")
	@NotNull
	@Size(min = 1, max = 100)
	private String name;

	@Column(name = "_ruc")
	@NotNull
	@Size(min = 1, max = 20)
	private String ruc;

	@Column(name = "creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date creationDate;
}
