package com.economysa.motor.app.promotion.entity;

import com.economysa.motor.app.core.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tprom_mechanic_product")
public class MechanicProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JoinColumn(name = "_product", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Product product;

  @NotNull
  @Column(name = "_mechanic")
  private Long mechanic;
}
