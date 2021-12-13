package com.adra.educate.entity;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "VIEW_PEDIDO_ORACION", uniqueConstraints = @UniqueConstraint(columnNames = {"id_pedido"}))
@Data
public class PedidosOracionReport {

    @Id
    @Column(name = "id_pedido", updatable = false, nullable = false)
    private Integer idPedido;

    @Column(name = "no_persona")
    private String no_persona;

    @Column(name = "fe_inicio")
    private String feInicio;

    @Column(name = "fe_fin")
    private String feFin;

    @Column(name = "es_pedido")
    private String esPedido;

}
