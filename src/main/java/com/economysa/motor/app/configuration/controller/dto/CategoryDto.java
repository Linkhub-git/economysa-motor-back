package com.economysa.motor.app.configuration.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

  private String parent;

  @NotNull
  @Size(min = 1, max = 50)
  private String name;
}
