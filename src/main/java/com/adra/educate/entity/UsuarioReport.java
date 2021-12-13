package com.adra.educate.entity;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "VW_SOCIO", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
@Data
public class UsuarioReport {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "dni")
    private String dni;

    @Column(name = "banco_comunal")
    private String bancoComunal;

    @Column(name = "avance")
    private String avance;

}
