package com.adra.educate.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "TMV_INSCRIPCION_SOCIO")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INSCRIPCION_SOCIO")
    private Integer idInscripcionSocio;

    @Column(name = "IN_VALORACION", length = 2)
    private Character inValoracion;

    @Column(name ="PO_AVANCE", length = 4)
    private Character poAvance;

    @Column(name = "ES_CAPACITACION", length = 1)
    private Character esCapacitacion;

    @Column(name = "FE_INSCRIPCION")
    private Date feInscripcion;

    @Column(name = "TOTAL_REC_VISTO", length = 10)
    private String totalRecVisto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_INS_SOCIO", foreignKey = @ForeignKey(name = "FK_INS_SOCIO"))
    private Socio socio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_INS_CAPACITACION", foreignKey = @ForeignKey(name = "FK_INS_CAPACITACION"))
    private Capacitacion capacitacion;

}
