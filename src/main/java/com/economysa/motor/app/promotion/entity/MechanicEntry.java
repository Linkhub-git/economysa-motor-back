package com.economysa.motor.app.promotion.entity;

import com.economysa.motor.util.ConstantMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tprom_mechanic_entry")
public class MechanicEntry {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "_mechanic")
  @NotNull
  private Long mechanic;

  @Column(name = "_type")
  @NotNull
  @Size(min = 1, max = 1)
  private String type;

  @Column(name = "_identifier")
  @NotNull
  private Long identifier;

  @Transient
  private String entryName;

  @Transient
  private String typeText;

  public String getTypeText() {
    switch (type) {
      case ConstantMessage.MECHANIC_ENTRY_TYPE_LIST:
        return ConstantMessage.MECHANIC_ENTRY_TYPE_LIST_TEXT;
      case ConstantMessage.MECHANIC_ENTRY_TYPE_GIRO:
        return ConstantMessage.MECHANIC_ENTRY_TYPE_GIRO_TEXT;
      default:
        throw new IllegalArgumentException("Invalid MechanicEntry type value: [ " + type + " ]");
    }
  }
}
