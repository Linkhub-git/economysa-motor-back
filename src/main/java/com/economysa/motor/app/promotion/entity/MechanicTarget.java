package com.economysa.motor.app.promotion.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tprom_mechanic_target")
public class MechanicTarget {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(name = "target_id")
  private Long targetId;

  @NotNull
  @Column(name = "_mechanic")
  private Long mechanic;

  @Transient
  private String targetName;
}
