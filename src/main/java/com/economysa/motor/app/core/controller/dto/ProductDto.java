package com.economysa.motor.app.core.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

  @NotNull
  private Long provider;

  @NotNull
  @Size(min = 1, max = 50)
  private String name;

  @NotNull
  @Size(min = 1, max = 20)
  private String purchasePackaging;

  @NotNull
  private BigDecimal masterStockAmount;

  @NotNull
  private BigDecimal salesPackaging;

  @NotNull
  private BigDecimal stockAmount;

  @NotNull
  private BigDecimal stock;

  @NotNull
  private BigDecimal basePrice;

  @NotNull
  private BigDecimal margin;
}
