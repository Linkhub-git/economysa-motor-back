package com.economysa.motor.app.core.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

  private String code;

  private String name;

  private String category;

  private String brand;

  private String provider;

  private Integer chatBot;

  private Integer tomaPedido;

  private String unitMaster;

  private String unitMasterDescription;

  private Integer unitMasterEquivalent;

  private String unitMin;

  private String unitMinDescription;

  private Integer unitMinEquivalent;
}
