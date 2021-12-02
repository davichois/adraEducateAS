package com.adra.educate.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TMA_SOCIO")
public class Socio implements Serializable {

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PER_SOCIO", foreignKey = @ForeignKey(name = "FK_SOC_PERSONA"))
    private Persona idPerSocio;

    @Column(name = "ES_SOCIO", length = 1)
    private Character esSocio;

    @Column(name = "ID_SOC_BC")
    private Integer idSocBC;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SOC_BC", foreignKey = @ForeignKey(name = "FK_SOC_BC"), insertable = false, updatable = false)
    private BancosComunal bancosComunal;

}
