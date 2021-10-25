package com.economysa.motor.app.promotion.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MechanicRequest {

  @NotNull
  @Size(min = 1, max = 1)
  private String mechanicType;

  @NotNull
  @Size(min = 1, max = 1)
  private String mechanicModality;

  @NotNull
  @Size(min = 1, max = 1)
  private String mechanicUnit;

  private BigDecimal factor;

  private BigDecimal bonusQuantity;

  private BigDecimal percentageDiscount;
}
