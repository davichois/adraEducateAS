package com.adra.educate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "TAX_PEDIDO")
public class PedidosOracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PEDIDO")
    private Integer idPedido;

    @Column(name = "DE_CONTENIDO", length = 245)
    private String deContenido;

    @Column(name = "ES_PEDIDO", length = 2)
    private Character esPedido;

    @Column(name = "FE_INICIO")
    private Date feInicio;

    @Column(name = "FE_FIN")
    private Date feFin;

    @Column(name = "ID_PED_PERSONA")
    private Integer idPedPersona;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PED_PERSONA", foreignKey = @ForeignKey(name = "FK_PED_PERSONA"), insertable = false, updatable = false)
    private Persona persona;

}
