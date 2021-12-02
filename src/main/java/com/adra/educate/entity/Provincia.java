package com.adra.educate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "TAX_PROVINCIA")
public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROVINCIA")
    private Integer idProvincia;

    @Column(name = "NO_PROVINCIA", length = 45)
    private String noProvincia;

    @Column(name = "ID_PRO_DEPARTAMENTO")
    private Integer idProDepartamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRO_DEPARTAMENTO", foreignKey = @ForeignKey(name = "FK_PRO_DEPARTAMENTO"), insertable = false, updatable = false)
    private Departamento departamento;

    @OneToMany(mappedBy = "provincia")
    private List<Distrito> distritos;

}
