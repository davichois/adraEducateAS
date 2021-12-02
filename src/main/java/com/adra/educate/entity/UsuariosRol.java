package com.adra.educate.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TSG_USUARIO_ROL")
public class UsuariosRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO_ROL")
    private Integer idUsuarioRol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USR_ROL", foreignKey = @ForeignKey(name = "FK_USR_ROL"))
    private Rol rol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USR_USUARIO", foreignKey = @ForeignKey(name = "FK_USR_USUARIO"))
    private Usuario usuario;

}
