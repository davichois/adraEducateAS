package com.adra.educate.entity;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "VW_PERSONA", uniqueConstraints = @UniqueConstraint(columnNames = {"id_persona"}))
@Data
public class PersonaReport {

    @Id
    @Column(name = "id_persona", updatable = false, nullable = false)
    private Integer idPersona;

    @Column(name = "no_persona")
    private String noPersona;

    @Column(name = "nu_dni")
    private String nuDni;

    @Column(name = "nu_telefono")
    private String nuTelefono;

    @Column(name = "di_persona")
    private String diPersona;

}
