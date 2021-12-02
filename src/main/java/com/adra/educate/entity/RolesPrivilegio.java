package com.adra.educate.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TSG_ROL_PRIVILEGIO")
public class RolesPrivilegio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ROL_PRIVILEGIO")
    private Integer idRolPrivilegio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ROP_ROL", foreignKey = @ForeignKey(name = "FK_ROP_ROL"))
    private Rol rol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ROP_PRIVILEGIO", foreignKey = @ForeignKey(name = "FK_ROP_PRIVILEGIO"))
    private Privilegio privilegio;

}
