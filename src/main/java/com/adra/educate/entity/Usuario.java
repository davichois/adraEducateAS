package com.adra.educate.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TSG_USUARIO")
public class Usuario implements Serializable {

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_USU_PERSONA", foreignKey = @ForeignKey(name = "FK_USU_PERSONA"))
    private Persona idUsuPersona;

    @Column(name = "USU_CREDENCIAL", length = 45)
    private String usuCredencial;

    @Column(name = "IS_ADMIN", length = 1)
    private Character isAdmin;

    @Column(name = "ES_USUARIO", length = 1)
    private Character esUsuario;

}
