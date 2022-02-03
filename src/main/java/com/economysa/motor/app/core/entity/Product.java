package com.economysa.motor.app.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tcore_product")
public class Product extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JoinColumn(name = "_provider", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Provider provider;

  @Column(name = "_name")
  @NotNull
  @Size(min = 1, max = 50)
  private String name;

  @Column(name = "purchase_packaging")
  @NotNull
  @Size(min = 1, max = 20)
  private String purchasePackaging;

  @Column(name = "master_stock_amount")
  @NotNull
  private BigDecimal masterStockAmount;

  @Column(name = "sales_packaging")
  @NotNull
  private BigDecimal salesPackaging;

  @Column(name = "stock_amount")
  @NotNull
  private BigDecimal stockAmount;

  @Column(name = "_stock")
  @NotNull
  private BigDecimal stock;

  @Column(name = "base_price")
  @NotNull
  private BigDecimal basePrice;

  @Column(name = "_margin")
  @NotNull
  private BigDecimal margin;

  @Column(name = "final_price")
  @NotNull
  private BigDecimal finalPrice;

  @Transient
  private String productDescription;

  public String getProductDescription() {
    return provider.getName() + " - " + name;
  }
}
