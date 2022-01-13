package com.economysa.motor.app.promotion.entity;

import com.economysa.motor.util.ConstantMessage;
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
@Table(name = "tprom_mechanic_detail_y")
public class MechanicDetailY {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JoinColumn(name = "_mechanic", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Mechanic mechanic;

  @Column(name = "_type")
  @NotNull
  @Size(min = 1, max = 1)
  private String type;

  @Column(name = "_code")
  @NotNull
  private Long code;

  @Column(name = "_factor")
  @NotNull
  private Integer factor;

  @Column(name = "_description")
  @NotNull
  @Size(min = 1, max = 100)
  private String description;

  @Transient
  private String typeText;

  public String getTypeText() {
    switch (type) {
      case ConstantMessage.MECHANIC_TYPE_ARTICLE:
        return ConstantMessage.MECHANIC_TYPE_ARTICLE_TEXT;
      case ConstantMessage.MECHANIC_TYPE_PROVIDER:
        return ConstantMessage.MECHANIC_TYPE_PROVIDER_TEXT;
      default:
        throw new IllegalArgumentException("Invalid Type");
    }
  }
}
