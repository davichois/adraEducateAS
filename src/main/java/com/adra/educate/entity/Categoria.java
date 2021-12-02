package com.adra.educate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "TAX_CATEGORIA")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CATEGORIA")
    private Integer idCategoria;

    @Column(name = "NO_CATEGORIA", length = 45)
    private String noCategoria;

    @OneToMany(mappedBy = "categoria")
    List<Capacitacion> capacitacions;

}
