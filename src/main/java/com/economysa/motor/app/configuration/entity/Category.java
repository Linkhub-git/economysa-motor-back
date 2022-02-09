package com.economysa.motor.app.configuration.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "tconf_category")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JoinColumn(name = "_parent", referencedColumnName = "id")
  @ManyToOne
  @JsonIgnore
  private Category parent;

  @Column(name = "_name")
  @NotNull
  @Size(min = 1, max = 50)
  private String name;

  @Transient
  private String parentName;

  public String getParentName() {
    return parent == null ? null : parent.getName();
  }
}
