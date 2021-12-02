package com.adra.educate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "TSG_PRIVILEGIO")
public class Privilegio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRIVILEGIO")
    private Integer idPrivilegio;

    @Column(name = "NO_PRIVILEGIO", length = 45)
    private String noPrivilegio;

    @Column(name = "PRI_URL")
    private String priURL;

    @Column(name = "PRI_ICON", length = 45)
    private String priIcon;

    @Column(name = "ES_PRIVILEGIO", length = 1)
    private Character esPrivilegio;

}
