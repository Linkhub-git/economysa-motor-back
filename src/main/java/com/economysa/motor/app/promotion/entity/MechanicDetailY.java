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

  @Column(name = "_identifier")
  @NotNull
  private Long identifier;

  @Column(name = "_code")
  @Size(max = 20)
  private String code;

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
      case ConstantMessage.MECHANIC_TYPE_CATEGORY:
        return ConstantMessage.MECHANIC_TYPE_CATEGORY_TEXT;
      case ConstantMessage.MECHANIC_TYPE_BRAND:
        return ConstantMessage.MECHANIC_TYPE_BRAND_TEXT;
      default:
        throw new IllegalArgumentException("Invalid Type value");
    }
  }
}
