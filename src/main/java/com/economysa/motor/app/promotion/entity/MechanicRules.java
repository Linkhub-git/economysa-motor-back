package com.economysa.motor.app.promotion.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Table(name = "tprom_mechanic_rules")
public class MechanicRules {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JoinColumn(name = "_mechanic", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Mechanic mechanic;
  
  @Column(name = "start_range")
  private BigDecimal startRange;
  
  @Column(name = "end_range")
  private BigDecimal endRange;
  
  @Column(name = "_priority")
  private Long priority;
  
  @Column(name = "_factor")
  private BigDecimal factor;
}
