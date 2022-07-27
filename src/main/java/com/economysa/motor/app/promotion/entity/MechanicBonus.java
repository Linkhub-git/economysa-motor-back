package com.economysa.motor.app.promotion.entity;

import com.economysa.motor.app.core.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tprom_mechanic_bonus")
public class MechanicBonus {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JoinColumn(name = "_rule", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private MechanicRules mechanicRules;

  @Column(name = "bonus_quantity")
  private BigDecimal bonusQuantity;

  @Column(name = "bonus_max")
  private BigDecimal bonusMax;

  @JoinColumn(name = "_product", referencedColumnName = "id")
  @ManyToOne
  private Product product;

  @Column(name = "quantity_use")
  @NotNull
  private BigDecimal quantityUse;
}
