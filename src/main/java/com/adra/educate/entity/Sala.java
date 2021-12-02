package com.adra.educate.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TAX_SALA")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SALA")
    private Integer idSala;

    @Column(name = "NO_SALA", length = 45)
    private String noSala;

    @Column(name = "DE_SALA", length = 125)
    private String deSala;

    @Column(name = "DURACION", length = 10)
    private String duracion;

    @Column(name = "FE_INICIO_SALA")
    private LocalDateTime feInicioSala;

    @Column(name = "FI_URL")
    private String fiURL;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SL_BCC", foreignKey = @ForeignKey(name = "FK_SL_BCC"))
    private BancosComunal bancosComunal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SL_SESION", foreignKey = @ForeignKey(name = "FK_SL_SESION"))
    private Sesion sesion;

}
