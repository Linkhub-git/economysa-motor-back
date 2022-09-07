package com.economysa.motor.app.promotion.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.economysa.motor.app.configuration.entity.QueryField;
import com.economysa.motor.app.configuration.entity.QueryOperator;
import com.economysa.motor.util.ConstantMessage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tprom_condition_rules")
public class ConditionRules {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "type")
  @NotNull
  @Size(min = 2, max = 2)
  private String type;
  
  @JoinColumn(name = "mechanic_id", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Mechanic mechanic;
    
  @JoinColumn(name = "field_id", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private QueryField field;
  
  @JoinColumn(name = "operator_id", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private QueryOperator operator;
  
  @Column(name = "value")
  @NotNull
  private String value;
  
  @Column(name = "creation_user")
  @NotNull
  private String creationUser;

  @Column(name = "creation_date")
  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  private Date creationDate;

  @Column(name = "update_user")
  private String updateUser;

  @Column(name = "update_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updateDate;

  @Column(name = "_status")
  @NotNull
  @Size(min = 1, max = 1)
  private String status;

  @Transient
  private String statusText;
  
  public String getStatusText() {
	    switch (status) {
	      case ConstantMessage.MECHANIC_STATUS_CREATED:
	        return ConstantMessage.MECHANIC_STATUS_CREATED_TEXT;
	      case ConstantMessage.MECHANIC_STATUS_DELETED:
	        return ConstantMessage.MECHANIC_STATUS_DELETED_TEXT;
	      default:
	        throw new IllegalArgumentException("Invalid Status");
	    }
	  }
  
}
