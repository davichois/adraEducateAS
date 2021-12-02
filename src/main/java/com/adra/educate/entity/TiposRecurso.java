package com.adra.educate.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TAX_TIPO_RECURSO")
public class TiposRecurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_DOCUMENTO")
    private Integer idTipoDocumento;

    @Column(name = "NO_TIPO_DOCUMENTO", length = 125)
    private String noTipoDocumento;

}
