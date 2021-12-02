package com.adra.educate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "TSG_ROL")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ROL")
    private Integer idRol;

    @Column(name = "NO_ROL", length = 45)
    private String noRol;

    @Column(name = "ES_ROL", length = 1)
    private Character esRol;

    @OneToMany(mappedBy = "rol", cascade = {CascadeType.ALL})
    private List<RolesPrivilegio> privilegios;

}
