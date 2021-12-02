package com.adra.educate.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TAX_REC_SALA")
public class RecSala implements Serializable {

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_REC_SALA", foreignKey = @ForeignKey(name = "FK_REC_SALA"))
    private Recurso idRecSala;

    @Column(name = "DURACION", length = 10)
    private String duracion;

    @Column(name = "FE_INICIO_REC_SALA")
    private LocalDateTime feInicioRecSala;

}
