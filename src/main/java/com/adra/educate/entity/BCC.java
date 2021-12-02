package com.adra.educate.entity;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_BCC_BC", foreignKey = @ForeignKey(name = "FK_BCC_BC"))
    private BancosComunal bancosComunal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_BCC_CAPACITACION", foreignKey = @ForeignKey(name = "FK_BCC_CAPACITACION"))
    private Capacitacion capacitacion;

}
