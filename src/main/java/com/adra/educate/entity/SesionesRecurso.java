package com.adra.educate.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TMV_SS_RE")
public class SesionesRecurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SS_RE")
    private Integer idSsRe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SR_SESION", foreignKey = @ForeignKey(name = "FK_SR_SESION"), insertable = false, updatable = false)
    private Sesion sesion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SR_RECURSO", foreignKey = @ForeignKey(name = "FK_SR_RECURSO"), insertable = false, updatable = false)
    private Recurso recurso;

}
