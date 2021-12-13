package com.adra.educate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@Table(name = "TMV_SESION")
public class Sesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SESION")
    private Integer idSesion;

    @Column(name = "NO_SESION", length = 45)
    private String noSesion;

    @Column(name = "DE_SESION", length = 150)
    private String deSesion;

    @Column(name = "FE_INICIO_SESION")
    private Date feInicioSesion;

    @Column(name = "FE_FIN_SESION")
    private Date feFinSesion;

    @Column(name = "ID_SES_CAPACITACION")
    private Integer idSesCapacitacion;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TMV_SS_RE",
        joinColumns = {
            @JoinColumn(name = "ID_SR_SESION", foreignKey = @ForeignKey(name = "FK_SR_SESION"), insertable = false, updatable = false)
        },
        inverseJoinColumns = {
            @JoinColumn(name = "ID_SR_RECURSO", foreignKey = @ForeignKey(name = "FK_SR_RECURSO"), insertable = false, updatable = false)
        },
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ID_SR_SESION", "ID_SR_RECURSO"})}
    )
    private Collection<Recurso> recursos = new ArrayList<>();

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "ID_SES_CAPACITACION", foreignKey = @ForeignKey(name = "FK_SES_CAPACITACION"), insertable = false, updatable = false)
    private Capacitacion capacitacion;

}
