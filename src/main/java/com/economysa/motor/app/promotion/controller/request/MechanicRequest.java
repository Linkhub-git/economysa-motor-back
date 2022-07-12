package com.economysa.motor.app.promotion.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MechanicRequest {

  @NotNull
  @Size(min = 1, max = 100)
  private String providerDescription;

  @NotNull
  @Size(min = 1, max = 100)
  private String catalogDescription;

  @NotNull
  private Date startDate;

  @NotNull
  private Date endDate;

  @NotNull
  private String startTime;

  @NotNull
  private String endTime;

  @NotNull
  @Size(min = 1, max = 1)
  private String accumulate;

  @NotNull
  @Size(min = 1, max = 1)
  private String promotionType;

  @NotNull
  @Size(min = 1, max = 1)
  private String type;

  private BigDecimal factor;

  @Size(max = 1)
  private String conditional;

  @NotNull
  @Size(min = 1, max = 1)
  private String emitter;

  private Long emitterId;
}
