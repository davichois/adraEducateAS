package com.adra.educate.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@Table(name = "TSG_USUARIO")
public class Usuario implements Serializable {

    @Id
    @JoinColumn(name = "ID_USU_PERSONA", foreignKey = @ForeignKey(name = "FK_USU_PERSONA"))
    private Integer idUsuPersona;

    @Column(name = "USU_CREDENCIAL", length = 45)
    private String usuCredencial;

    @Column(name = "PWD_CREDENCIAL", length = 45)
    private String pwdCredencial;

    @Column(name = "ES_USUARIO", length = 1)
    private Character esUsuario;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TSG_USUARIO_ROL",
            joinColumns = {
                @JoinColumn(name = "ID_USR_USUARIO", foreignKey = @ForeignKey(name = "FK_USR_USUARIO"))
            },
            inverseJoinColumns = {
                @JoinColumn(name = "ID_USR_ROL", foreignKey = @ForeignKey(name = "FK_USR_ROL"))
            }
    )
    private Collection<Rol> rols = new ArrayList<>();

}
