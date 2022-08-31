package com.economysa.motor.app.configuration.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QueryCondFieldId implements Serializable{

	  private Long queryCondition;
	  private Long queryField;
	  
	 
}
