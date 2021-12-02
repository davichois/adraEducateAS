package com.adra.educate.service;

import com.adra.educate.entity.PedidosOracion;

import java.util.List;
import java.util.Optional;

public interface PedidosOracionService {

    List<PedidosOracion> listPedidosOracion();

    Optional<PedidosOracion> findPedidosOracion(Integer idCategoria);

    PedidosOracion savePedidosOracion(PedidosOracion categoria);

    void deletePedidosOracion(Integer idCategoria);

}
