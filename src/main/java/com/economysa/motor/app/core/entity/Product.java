package com.economysa.motor.app.core.entity;

import com.economysa.motor.app.configuration.entity.Brand;
import com.economysa.motor.app.configuration.entity.Category;
import com.economysa.motor.app.configuration.entity.Unity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tcore_product")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "_code")
  @NotNull
  @Size(min = 1, max = 10)
  private String code;

  @Column(name = "_name")
  @NotNull
  @Size(min = 1, max = 256)
  private String name;

  @JoinColumn(name = "_category", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Category category;

  @JoinColumn(name = "_brand", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Brand brand;

  @JoinColumn(name = "_provider", referencedColumnName = "id")
  @ManyToOne
  private Provider provider;

  @Column(name = "chatbot")
  @NotNull
  private Boolean chatBot;

  @Column(name = "toma_pedido")
  @NotNull
  private Boolean tomaPedido;

  @JoinColumn(name = "unity_master")
  @ManyToOne(optional = false)
  private Unity unitMaster;

  @Column(name = "unity_master_description")
  @NotNull
  @Size(min = 1, max = 100)
  private String unitMasterDescription;

  @Column(name = "unity_master_equivalent")
  @NotNull
  private Integer unitMasterEquivalent;

  @JoinColumn(name = "unity_min", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Unity unitMin;

  @Column(name = "unity_min_description")
  @NotNull
  @Size(min = 1, max = 100)
  private String unitMinDescription;

  @Column(name = "unity_min_equivalent")
  @NotNull
  private Integer unitMinEquivalent;

  @Column(name = "creation_date")
  @Temporal(TemporalType.TIMESTAMP)
  @NotNull
  private Date creationDate;
}
