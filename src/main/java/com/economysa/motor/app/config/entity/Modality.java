package com.economysa.motor.app.config.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@Table(name = "tconf_modality")
@ApiModel(value = "Modalidad", description = "Define una Modalidad de Economysa")
public class Modality {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(
      name = "id",
      value = "Identificador único por Modalidad",
      example = "1",
      dataType = "Long",
      required = true,
      position = 0
  )
  private Long id;

  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "_code")
  @ApiModelProperty(
      name = "code",
      value = "Código de la Modalidad",
      example = "P|C|M|A",
      dataType = "String",
      required = true,
      position = 1
  )
  private String code;

  @NotNull
  @Size(min = 1, max = 20)
  @Column(name = "_name")
  @ApiModelProperty(
      name = "name",
      value = "Nombre de la Modalidad",
      example = "Proveedor|Categoria|Marca|Articulo",
      dataType = "String",
      required = true,
      position = 2
  )
  private String name;
}
