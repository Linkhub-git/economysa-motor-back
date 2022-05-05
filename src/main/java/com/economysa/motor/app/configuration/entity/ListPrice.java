package com.economysa.motor.app.configuration.entity;

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
@Table(name = "tconf_list_price")
public class ListPrice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "_code")
  @NotNull
  @Size(min = 1, max = 5)
  private String code;

  @Column(name = "_description")
  @NotNull
  @Size(min = 1, max = 100)
  private String description;

  @Transient
  private String formatted;

  public String getFormatted() {
    return code + " - " + description;
  }
}
