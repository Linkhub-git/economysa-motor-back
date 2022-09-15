package com.economysa.motor.app.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tconf_province")
public class Province {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  @Column(name = "_name")
	  @NotNull
	  @Size(min = 1, max = 256)
	  private String name;
	  
	  @JoinColumn(name = "department_id", referencedColumnName = "id")
	  @ManyToOne(optional = false)
	  private Department department;
	  
  }
