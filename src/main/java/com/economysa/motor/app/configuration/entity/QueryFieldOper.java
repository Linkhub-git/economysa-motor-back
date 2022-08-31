package com.economysa.motor.app.configuration.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@IdClass(QueryFieldOperId.class)
@Table(name = "tconf_query_field_oper")
public class QueryFieldOper implements Serializable{
	
	  @Id
	  @JoinColumn(name = "field_id", referencedColumnName = "id")
	  @ManyToOne(optional = false)
	  private QueryField queryField;
	  
	  @Id
	  @JoinColumn(name = "operator_id", referencedColumnName = "id")
	  @ManyToOne(optional = false)
	  private QueryOperator queryOperator;
	  
}
