package com.economysa.motor.app.promotion.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MechanicDetailYRequest {

  @NotNull
  private Long mechanic;

  @NotNull
  @Size(min = 1, max = 1)
  private String type;

  @NotNull
  private Long code;

  @NotNull
  @Size(min = 1, max = 100)
  private String description;
}
