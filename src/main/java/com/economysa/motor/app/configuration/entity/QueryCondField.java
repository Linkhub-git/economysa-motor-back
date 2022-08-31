package com.economysa.motor.app.configuration.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tconf_query_cond_field")
public class QueryCondField implements Serializable{

	  @Id
	  @JoinColumn(name = "condition_id", referencedColumnName = "id")
	  @ManyToOne(optional = false)
	  private QueryCondition queryCondition;
	  
	  @Id
	  @JoinColumn(name = "field_id", referencedColumnName = "id")
	  @ManyToOne(optional = false)
	  private QueryField queryField;
	  
	 
}
