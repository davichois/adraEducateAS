package com.adra.educate.entity;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "VW_CAPACITACION", uniqueConstraints = @UniqueConstraint(columnNames = {"id_capacitacion"}))
@Data
public class CapacitacionReport {

    @Id
    @Column(name = "id_capacitacion", updatable = false, nullable = false)
    private Integer idCapacitacion;

    @Column(name = "no_capacitacion")
    private String noCapacitacion;

    @Column(name = "no_categoria")
    private String noCategoria;

    @Column(name = "ti_capacitacion")
    private String tiCapacitacion;

    @Column(name = "nu_sesiones")
    private Integer nuSesiones;

}
