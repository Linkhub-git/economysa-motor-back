package com.economysa.motor.app.promotion.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MechanicTargetRequest {

  @NotNull
  private Long targetId;

  @NotNull
  private Long mechanic;
}
