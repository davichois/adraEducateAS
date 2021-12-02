package com.adra.educate.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TMV_RECURSO_SOCIO")
public class RecursosSocio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RECURSO_SOCIO")
    private Integer idRecursoSocio;

    @Column(name = "ES_RECURSO_SOCIO", length = 1)
    private Character esRecursoSocio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_RS_SOCIO", foreignKey = @ForeignKey(name = "FK_RS_SOCIO"))
    private Socio socio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_RS_RECURSO", foreignKey = @ForeignKey(name = "FK_RS_RECURSO"))
    private Recurso recurso;

}
