package com.economysa.motor.app.promotion.controller.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
  private String startDate;

  @NotNull
  private String endDate;

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

  @Size(max = 1)
  private String conditional;

  @NotNull
  @Size(min = 1, max = 1)
  private String emitter;

  private Long emitterId;
}
