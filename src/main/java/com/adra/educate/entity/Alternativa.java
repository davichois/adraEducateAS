package com.adra.educate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TAX_ALTERNATIVA")
public class Alternativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRE_ALTERNATIVA")
    private Integer idPreAlternativa;

    @Column(name = "NO_ALTERNATIVA", length = 150)
    private String noAlternativa;

    @Column(name = "ES_ALTERNATIVA", length = 1)
    private Character esAlternativa;

    @Column(name = "ID_ALT_PREGUNTA")
    private Integer idAltPregunta;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_ALT_PREGUNTA", foreignKey = @ForeignKey(name = "FK_ALT_PREGUNTA"), insertable = false, updatable = false)
    private Pregunta pregunta;

}
