package com.economysa.motor.app.promotion.entity;

import com.economysa.motor.app.core.entity.BaseEntity;
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
public class MechanicBonus extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JoinColumn(name = "product_id", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Product product;

  @NotNull
  @Column(name = "_mechanic")
  private Long mechanic;

  @NotNull
  @Column(name = "_stock")
  private BigDecimal stock;
}
