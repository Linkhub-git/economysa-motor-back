package com.economysa.motor.app.promotion.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.economysa.motor.util.ConstantMessage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tprom_search_group")
public class SearchGroup {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "group_operator")
  @NotNull
  @Size(min = 2, max = 3)
  private String groupOperator;
  
  @JoinColumn(name = "search_id", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Search search;
  
  @OneToMany(
	        mappedBy = "searchGroup",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
  private List<SearchCondition> conditions = new ArrayList<>();
  
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
