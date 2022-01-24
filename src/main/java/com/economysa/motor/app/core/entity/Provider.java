package com.economysa.motor.app.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tcore_provider")
public class Provider extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "_name")
	@NotNull
	@Size(min = 1, max = 50)
	private String name;

	@Column(name = "_ruc")
	@NotNull
	@Size(min = 1, max = 20)
	private String ruc;
}
