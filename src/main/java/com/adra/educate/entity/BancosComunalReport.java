package com.adra.educate.entity;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "VW_BANCO_COMUNAL", uniqueConstraints = @UniqueConstraint(columnNames = {"id_bc"}))
@Data
public class BancosComunalReport {

    @Id
    @Column(name = "id_bc", updatable = false, nullable = false)
    private Integer idBC;

    @Column(name = "no_bc")
    private String noBC;

    @Column(name = "dis_bc")
    private String disBC;

    @Column(name = "pro_bc")
    private String proBC;

    @Column(name = "dep_bc")
    private String depBC;

}
