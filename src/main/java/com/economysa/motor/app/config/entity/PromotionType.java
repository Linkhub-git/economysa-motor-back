package com.economysa.motor.app.config.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tconf_promotion_type")
public class PromotionType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "_code")
  private String code;

  @NotNull
  @Size(min = 1, max = 20)
  @Column(name = "_name")
  private String name;
}
