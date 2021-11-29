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
  @Size(min = 1, max = 20)
  private String code;

  @NotNull
  @Size(min = 1, max = 100)
  private String description;

  @NotNull
  private Long startDate;

  @NotNull
  private Long endDate;

  @NotNull
  @Size(min = 1, max = 1)
  private String accumulate;

  @NotNull
  @Size(min = 1, max = 1)
  private String promotionType;

  @NotNull
  @Size(min = 1, max = 1)
  private String type;

  private BigDecimal range1;

  private BigDecimal range2;

  private BigDecimal factor;

  @Size(max = 1)
  private String conditional;
}
