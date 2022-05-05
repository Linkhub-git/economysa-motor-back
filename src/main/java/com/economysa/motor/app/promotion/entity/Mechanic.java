package com.economysa.motor.app.promotion.entity;

import com.economysa.motor.app.configuration.entity.ListPrice;
import com.economysa.motor.app.core.entity.Provider;
import com.economysa.motor.util.ConstantMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tprom_mechanic")
public class Mechanic {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "_code")
  @NotNull
  @Size(min = 1, max = 20)
  private String code;

  @Column(name = "_description")
  @NotNull
  @Size(min = 1, max = 100)
  private String description;

  @Column(name = "start_date")
  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  private Date startDate;

  @Column(name = "end_date")
  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  private Date endDate;

  @Column(name = "accumulate")
  @NotNull
  @Size(min = 1, max = 1)
  private String accumulate;

  @Column(name = "promotion_type")
  @NotNull
  @Size(min = 1, max = 1)
  private String promotionType;

  @Column(name = "_type")
  @NotNull
  @Size(min = 1, max = 1)
  private String type;

  @Column(name = "range1")
  private BigDecimal range1;

  @Column(name = "range2")
  private BigDecimal range2;

  @Column(name = "_factor")
  private BigDecimal factor;

  @Column(name = "conditional")
  @Size(max = 1)
  private String conditional;

  @Column(name = "emitter")
  @Size(min = 1, max = 1)
  private String emitter;

  @JoinColumn(name = "emitter_id", referencedColumnName = "id")
  @ManyToOne
  private Provider emitterObj;

  @Column(name = "creation_user")
  @NotNull
  private String creationUser;

  @Column(name = "creation_date")
  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  private Date creationDate;

  @Column(name = "update_user")
  private String updateUser;

  @Column(name = "update_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updateDate;

  @Column(name = "_status")
  @NotNull
  @Size(min = 1, max = 1)
  private String status;

  @Transient
  private String statusText;

  @Transient
  private String emitterText;

  public String getEmitterText() {
    switch (emitter) {
      case ConstantMessage.EMITTER_PROVIDER:
        return ConstantMessage.EMITTER_PROVIDER_TEXT;
      case ConstantMessage.EMITTER_ECONOMYSA:
        return ConstantMessage.EMITTER_ECONOMYSA_TEXT;
      default:
        throw new IllegalArgumentException("Invalid Emitter");
    }
  }

  public String getStatusText() {
    switch (status) {
      case ConstantMessage.MECHANIC_STATUS_CREATED:
        return ConstantMessage.MECHANIC_STATUS_CREATED_TEXT;
      case ConstantMessage.MECHANIC_STATUS_DELETED:
        return ConstantMessage.MECHANIC_STATUS_DELETED_TEXT;
      default:
        throw new IllegalArgumentException("Invalid Status");
    }
  }
}
