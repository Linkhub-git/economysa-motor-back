package com.economysa.motor.app.promotion.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tprom_mechanic_rules")
public class MechanicRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "_mechanic", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Mechanic mechanic;

    @Column(name = "start_range")
    private Double startRange;

    @Column(name = "end_range")
    private Double endRange;

    @Column(name = "_factor")
    private Double  factor;

    @Column(name = "_priority")
    @NotNull
    private Integer priority;
}
