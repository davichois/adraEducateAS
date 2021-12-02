package com.adra.educate.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SES_CAPACITACION", foreignKey = @ForeignKey(name = "FK_SES_CAPACITACION"), insertable = false, updatable = false)
    private Capacitacion capacitacion;

}
