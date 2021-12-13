package com.adra.educate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "TMV_CAPACITACION")
public class Capacitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CAPACITACION")
    private Integer idCapacitacion;

    @Column(name = "NO_CAPACITACION", length = 45)
    private String noCapacitacion;

    @Column(name = "DE_CAPACITACION", length = 45)
    private String deCapacitacion;

    @Column(name = "FE_INICIO_CAPACITACION")
    private Date feInicioCapacitacion;

    @Column(name = "FE_FIN_CAPACITACION")
    private Date feFinCapacitacion;

    @Column(name = "TI_CAPACITACION", length = 45)
    private String tiCapacitacion;

    @Column(name = "ID_CAP_CATEGORIA")
    private Integer idCapCategoria;

    @Column(name = "TOTAL_REC_CAPACITACION", length = 10)
    private String totalRecCapacitacion;

    @Column(name = "ES_CAPACITACION", length = 1)
    private Character esCapacitacion;

    @Column(name = "FI_IMAGE_URL")
    private String fiImageURL;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CAP_CATEGORIA", foreignKey = @ForeignKey(name = "FK_CAP_CATEGORIA"), insertable = false, updatable = false)
    private Categoria categoria;

    @OneToMany(mappedBy = "capacitacion")
    private List<Sesion> sesions;

}
