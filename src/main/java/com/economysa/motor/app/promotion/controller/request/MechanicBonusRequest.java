package com.economysa.motor.app.promotion.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MechanicBonusRequest {

  @NotNull
  private Long productId;

  @NotNull
  private Long mechanic;

  @NotNull
  private BigDecimal stock;
}
