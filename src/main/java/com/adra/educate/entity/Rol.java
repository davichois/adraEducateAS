package com.adra.educate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@Table(name = "TSG_ROL")
@NoArgsConstructor
@AllArgsConstructor
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ROL")
    private Integer idRol;

    @Column(name = "NO_ROL", length = 45)
    private String noRol;

    @Column(name = "ES_ROL", length = 1)
    private Character esRol;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TSG_ROL_PRIVILEGIO",
            joinColumns = {
                    @JoinColumn(name = "ID_ROP_ROL", foreignKey = @ForeignKey(name = "FK_ROP_ROL"))
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ID_ROP_PRIVILEGIO", foreignKey = @ForeignKey(name = "FK_ROP_PRIVILEGIO"))
            },
            uniqueConstraints = {@UniqueConstraint(columnNames = {"ID_ROP_ROL", "ID_ROP_PRIVILEGIO"})}
    )
    private Collection<Privilegio> privilegios = new ArrayList<>();

}
