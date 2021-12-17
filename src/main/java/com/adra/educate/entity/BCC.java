package com.adra.educate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "TMV_BCC")
public class BCC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BCC")
    private Integer idBCC;

    @Column(name = "ES_BCC", length = 1)
    private Character esBCC;

    @Column(name = "FE_BCC")
    private Date feBcc;

    @Column(name = "ID_BCC_BC")
    private Integer idBanco;

    @Column(name = "ID_BCC_CAPACITACION")
    private Integer idCapacitacion;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_BCC_BC", foreignKey = @ForeignKey(name = "FK_BCC_BC"), insertable = false, updatable = false)
    private BancosComunal bancosComunal;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_BCC_CAPACITACION", foreignKey = @ForeignKey(name = "FK_BCC_CAPACITACION"), insertable = false, updatable = false)
    private Capacitacion capacitacion;

}
