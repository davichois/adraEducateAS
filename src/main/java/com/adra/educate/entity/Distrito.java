package com.adra.educate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "TAX_DISTRITO")
public class Distrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DISTRITO")
    private Integer idDistrito;

    @Column(name = "NO_DISTRITO", length = 45)
    private String noDistrito;

    @Column(name = "ID_DIS_PROVINCIA")
    private Integer idDisProcincia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DIS_PROVINCIA", foreignKey = @ForeignKey(name = "FK_DIS_PROVINCIA"), insertable = false, updatable = false)
    private Provincia provincia;

    @OneToMany(mappedBy = "distrito")
    private List<BancosComunal> bancosComunals;

}
