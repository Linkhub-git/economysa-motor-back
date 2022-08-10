package com.economysa.motor.app.promotion.entity;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tprom_mechanic_discount")
public class MechanicDiscount {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JoinColumn(name = "_rule", referencedColumnName = "id")
  @OneToOne(optional = false)
  private MechanicRules mechanicRules;
  
  @Column(name = "percentage_discount")
  @NotNull
  private BigDecimal percentageDiscount;

}
