package com.economysa.motor.app.promotion.entity;

import com.economysa.motor.app.core.entity.BaseEntity;
import com.economysa.motor.util.ConstantMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tprom_mechanic")
public class Mechanic extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "mechanic_type")
  private String mechanicType;

  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "mechanic_modality")
  private String mechanicModality;

  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "mechanic_unit")
  private String mechanicUnit;

  @NotNull
  @Size(min = 1, max = 10)
  @Column(name = "target_id")
  private String targetId;

  @Column(name = "_factor")
  private BigDecimal factor;

  @Column(name = "bonus_quantity")
  private BigDecimal bonusQuantity;

  @Column(name = "percentage_discount")
  private BigDecimal percentageDiscount;

  @Transient
  private String mechanicTypeText;

  @Transient
  private String mechanicModalityText;

  @Transient
  private String mechanicUnitText;

  public String getMechanicTypeText() {
    switch (mechanicType) {
      case ConstantMessage.MECHANIC_TYPE_BONUS:
        return ConstantMessage.MECHANIC_TYPE_BONUS_TEXT;
      case ConstantMessage.MECHANIC_TYPE_SOLES:
        return ConstantMessage.MECHANIC_TYPE_SOLES_TEXT;
      default:
        throw new IllegalArgumentException("No MechanicType found for this value");
    }
  }

  public String getMechanicModalityText() {
    switch (mechanicModality) {
      case ConstantMessage.MECHANIC_MODALITY_PROVIDER:
        return ConstantMessage.MECHANIC_MODALITY_PROVIDER_TEXT;
      case ConstantMessage.MECHANIC_MODALITY_ARTICLE:
        return ConstantMessage.MECHANIC_MODALITY_ARTICLE_TEXT;
      default:
        throw new IllegalArgumentException("No MechanicModality found for this value");
    }
  }

  public String getMechanicUnitText() {
    switch (mechanicUnit) {
      case ConstantMessage.MECHANIC_UNIT_UNITY:
        return ConstantMessage.MECHANIC_UNIT_UNITY_TEXT;
      case ConstantMessage.MECHANIC_UNIT_SOLES:
        return ConstantMessage.MECHANIC_UNIT_SOLES_TEXT;
      default:
        throw new IllegalArgumentException("No Mechanicunit found for this value");
    }
  }
}
