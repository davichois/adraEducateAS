package com.adra.educate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "TAX_PREGUNTA")
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REC_PREGUNTA")
    private Integer idRecPregunta;

    @Column(name = "NO_PREGUNTA", length = 200)
    private String noPregunta;

    @Column(name = "ID_PRE_REC")
    private Integer idPreRec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRE_REC", foreignKey = @ForeignKey(name = "FK_PRE_REC"), insertable = false, updatable = false)
    private Recurso recurso;

    @OneToMany(mappedBy = "pregunta")
    private List<Alternativa> alternativas;

}
