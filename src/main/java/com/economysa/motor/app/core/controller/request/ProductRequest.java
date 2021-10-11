package com.economysa.motor.app.core.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Producto Request", description = "Contiene la información necesaria para crear/actualizar un Producto")
public class ProductRequest {

  @Size(max = 20)
  @ApiModelProperty(
      name = "id",
      value = "Identificador único por Producto",
      example = "0007963",
      dataType = "String",
      required = true,
      position = 0
  )
  private String id;

  @NotNull
  @Size(min = 1, max = 20)
  @ApiModelProperty(
      name = "provider",
      value = "Proveedor al cual pertenece el producto",
      example = "0007690",
      dataType = "Provider",
      required = true,
      position = 1
  )
  private String provider;

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
}
