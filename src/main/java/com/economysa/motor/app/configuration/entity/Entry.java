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
@Table(name = "tconf_list_price_entry")
public class Entry {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JoinColumn(name = "list_price", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private ListPrice listPrice;

  @Column(name = "_code")
  @Size(min = 1, max = 10)
  @NotNull
  private String code;

  @Column(name = "_description")
  @Size(min = 1, max = 100)
  @NotNull
  private String description;

  @Transient
  private String formatted;

  public String getFormatted() {
    return listPrice.getFormatted() + " / " + description;
  }
}
