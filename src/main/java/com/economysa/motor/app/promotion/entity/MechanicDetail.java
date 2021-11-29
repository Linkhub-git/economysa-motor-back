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
@Table(name = "tprom_mechanic_detail")
public class MechanicDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JoinColumn(name = "_mechanic", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Mechanic mechanic;

  @Column(name = "_included")
  @NotNull
  @Size(min = 1, max = 1)
  private String included;

  @Column(name = "_type")
  @NotNull
  @Size(min = 1, max = 1)
  private String type;

  @Column(name = "_code")
  @NotNull
  private Long code;

  @Column(name = "_description")
  @NotNull
  @Size(min = 1, max = 100)
  private String description;

  @Transient
  private String includedText;

  @Transient
  private String typeText;

  public String getIncludedText() {
    switch (included) {
      case ConstantMessage.MECHANIC_INCLUDED_YES:
        return ConstantMessage.MECHANIC_INCLUDED_YES_TEXT;
      case ConstantMessage.MECHANIC_INCLUDED_NO:
        return ConstantMessage.MECHANIC_INCLUDED_NO_TEXT;
      default:
        throw new IllegalArgumentException("Invalid Included value");
    }
  }

  public String getTypeText() {
    switch (type) {
      case ConstantMessage.MECHANIC_TYPE_ARTICLE:
        return ConstantMessage.MECHANIC_TYPE_ARTICLE_TEXT;
      case ConstantMessage.MECHANIC_TYPE_PROVIDER:
        return ConstantMessage.MECHANIC_TYPE_PROVIDER_TEXT;
      default:
        throw new IllegalArgumentException("Invalid Type value");
    }
  }
}
