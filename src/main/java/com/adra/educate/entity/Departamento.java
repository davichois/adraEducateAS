package com.adra.educate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "TAX_DEPARTAMENTO")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DEPARTAMENTO")
    private Integer idDepartamento;

    @Column(name = "NO_DEPARTAMENTO", length = 45)
    private String noDepartamento;

    @OneToMany(mappedBy = "departamento")
    private List<Provincia> provincias;

}
