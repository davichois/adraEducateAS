package com.adra.educate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "TMA_PERSONA")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERSONA")
    private Integer idPersona;

    @Column(name = "NO_PERSONA", length = 45)
    private String noPersona;

    @Column(name = "AP_PATERNO", length = 45)
    private String apPaterno;

    @Column(name = "AP_MATERNO", length = 45)
    private String apMaterno;

    @Column(name = "NU_TELEFONO", length = 12)
    private String nuTelefono;

    @Column(name = "NU_DNI", length = 8)
    private String nuDNI;

    @Column(name = "DI_PERSONA")
    private String diPersona;

    @Column(name = "TI_SEXO", length = 2)
    private Character tiSexo;

    @Transient
    private Integer idBancoComunal;

    @Column(name = "ES_PERSONA", length = 1)
    private Character esPersona;

    @JsonIgnore
    @OneToOne(mappedBy = "idPerSocio")
    private Socio socio;

    @JsonIgnore
    @OneToOne(mappedBy = "idUsuPersona")
    private Usuario usuario;

}
