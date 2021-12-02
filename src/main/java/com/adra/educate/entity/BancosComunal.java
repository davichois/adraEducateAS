package com.adra.educate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "TMA_BANCO_COMUNAL")
public class BancosComunal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BANCO_COMUNAL")
    private Integer idBancoComunal;

    @Column(name = "NO_BANCO_COMUNAL", length = 45)
    private String noBancoComunal;

    @Column(name = "ID_BC_DISTRITO")
    private Integer idBcDistrito;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_BC_DISTRITO", foreignKey = @ForeignKey(name = "FK_BC_DISTRITO"), insertable = false, updatable = false)
    private Distrito distrito;

    @JsonIgnore
    @OneToMany(mappedBy = "bancosComunal")
    private List<Socio> socios;

}
