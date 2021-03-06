package com.adra.educate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "TMV_RECURSO")
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RECURSO")
    private Integer idRecurso;

    @Column(name = "NO_RECURSO", length = 45)
    private String noRecurso;

    @Column(name = "DE_RECURSO")
    private String deRecurso;

    @Column(name = "FI_URL")
    private String fiURL;

    @Column(name = "ID_REC_TIPODOC")
    private Integer idRecTipoDoc;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_REC_TIPODOC", foreignKey = @ForeignKey(name = "FK_REC_TIPODOC"), insertable = false, updatable = false)
    private TiposRecurso tipoRecurso;

    @JsonIgnore
    @OneToOne(mappedBy = "idRecSala")
    private RecSala recSala;

    @JsonIgnore
    @OneToMany(mappedBy = "recurso")
    private List<Pregunta> preguntas;

}
