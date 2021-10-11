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
  @Size(max = 10)
  @Column(name = "id", updatable = false, unique = true)
  @ApiModelProperty(
      name = "id",
      value = "Identificador único por Producto",
      example = "0007963",
      dataType = "String",
      required = true,
      position = 0
  )
  private String id;

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

  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "_name")
  @ApiModelProperty(
      name = "name",
      value = "Nombre del producto",
      example = "DOVE JABON BLANCO ORIGINAL 90GR",
      dataType = "String",
      required = true,
      position = 2
  )
  private String name;

  @NotNull
  @Size(min = 1, max = 20)
  @Column(name = "purchase_packaging")
  @ApiModelProperty(
      name = "purchasePackaging",
      value = "PurchasePackaging",
      example = "CAJA x 48 und.",
      dataType = "String",
      required = true,
      position = 3
  )
  private String purchasePackaging;

  @NotNull
  @Column(name = "master_stock_amount")
  @ApiModelProperty(
      name = "masterStockAmount",
      value = "MasterStockAmount",
      example = "100",
      dataType = "BigDecimal",
      required = true,
      position = 4
  )
  private BigDecimal masterStockAmount;

  @NotNull
  @Column(name = "sales_packaging")
  @ApiModelProperty(
      name = "salesPackaging",
      value = "SalesPackaging",
      example = "117.12",
      dataType = "BigDecimal",
      required = true,
      position = 5
  )
  private BigDecimal salesPackaging;

  @NotNull
  @Column(name = "stock_amount")
  @ApiModelProperty(
      name = "stockAmount",
      value = "StockAmount",
      example = "100",
      dataType = "BigDecimal",
      required = true,
      position = 6
  )
  private BigDecimal stockAmount;

  @NotNull
  @Column(name = "_stock")
  @ApiModelProperty(
      name = "stock",
      value = "Stock",
      example = "100",
      dataType = "BigDecimal",
      required = true,
      position = 7
  )
  private BigDecimal stock;

  @NotNull
  @Column(name = "base_price")
  @ApiModelProperty(
      name = "basePrice",
      value = "BasePrice",
      example = "117.12",
      dataType = "BigDecimal",
      required = true,
      position = 8
  )
  private BigDecimal basePrice;

  @NotNull
  @Column(name = "_margin")
  @ApiModelProperty(
      name = "margin",
      value = "Margin",
      example = "12",
      dataType = "BigDecimal",
      required = true,
      position = 9
  )
  private BigDecimal margin;

  @NotNull
  @Column(name = "final_price")
  @ApiModelProperty(
      name = "finalPrice",
      value = "FinalPrice",
      example = "101.28",
      dataType = "BigDecimal",
      required = true,
      position = 10
  )
  private BigDecimal finalPrice;
}
