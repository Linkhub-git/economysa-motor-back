package com.economysa.motor.app.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "Product", description = "Define a un producto de Economysa")
public class Product extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(
      name = "id",
      value = "Identificador único por Producto",
      example = "1000",
      dataType = "Long",
      required = true,
      position = 0
  )
  private Long id;

  @JoinColumn(name = "_provider", referencedColumnName = "id")
  @ManyToOne(optional = false)
  @ApiModelProperty(
      name = "provider",
      value = "Proveedor al cual pertenece el producto",
      example = "<Objeto Proveedor>",
      dataType = "Provider",
      required = true,
      position = 1
  )
  private Provider provider;

  @Column(name = "_name")
  @NotNull
  @Size(min = 1, max = 50)
  @ApiModelProperty(
      name = "name",
      value = "Nombre del producto",
      example = "DOVE JABON BLANCO ORIGINAL 90GR",
      dataType = "String",
      required = true,
      position = 2
  )
  private String name;

  @Column(name = "purchase_packaging")
  @NotNull
  @Size(min = 1, max = 20)
  @ApiModelProperty(
      name = "purchasePackaging",
      value = "PurchasePackaging",
      example = "CAJA x 48 und.",
      dataType = "String",
      required = true,
      position = 3
  )
  private String purchasePackaging;

  @Column(name = "master_stock_amount")
  @NotNull
  @ApiModelProperty(
      name = "masterStockAmount",
      value = "MasterStockAmount",
      example = "100",
      dataType = "BigDecimal",
      required = true,
      position = 4
  )
  private BigDecimal masterStockAmount;

  @Column(name = "sales_packaging")
  @NotNull
  @ApiModelProperty(
      name = "salesPackaging",
      value = "SalesPackaging",
      example = "117.12",
      dataType = "BigDecimal",
      required = true,
      position = 5
  )
  private BigDecimal salesPackaging;

  @Column(name = "stock_amount")
  @NotNull
  @ApiModelProperty(
      name = "stockAmount",
      value = "StockAmount",
      example = "100",
      dataType = "BigDecimal",
      required = true,
      position = 6
  )
  private BigDecimal stockAmount;

  @Column(name = "_stock")
  @NotNull
  @ApiModelProperty(
      name = "stock",
      value = "Stock",
      example = "100",
      dataType = "BigDecimal",
      required = true,
      position = 7
  )
  private BigDecimal stock;

  @Column(name = "base_price")
  @NotNull
  @ApiModelProperty(
      name = "basePrice",
      value = "BasePrice",
      example = "117.12",
      dataType = "BigDecimal",
      required = true,
      position = 8
  )
  private BigDecimal basePrice;

  @Column(name = "_margin")
  @NotNull
  @ApiModelProperty(
      name = "margin",
      value = "Margin",
      example = "12",
      dataType = "BigDecimal",
      required = true,
      position = 9
  )
  private BigDecimal margin;

  @Column(name = "final_price")
  @NotNull
  @ApiModelProperty(
      name = "finalPrice",
      value = "FinalPrice",
      example = "101.28",
      dataType = "BigDecimal",
      required = true,
      position = 10
  )
  private BigDecimal finalPrice;

  @Transient
  private String productDescription;

  public String getProductDescription() {
    return provider.getName() + " - " + name;
  }
}
