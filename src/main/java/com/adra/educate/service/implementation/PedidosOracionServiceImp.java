package com.adra.educate.service.implementation;

import com.adra.educate.entity.PedidosOracion;
import com.adra.educate.repository.PedidosOracionRepository;
import com.adra.educate.service.PedidosOracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidosOracionServiceImp implements PedidosOracionService {

    @Autowired
    private PedidosOracionRepository pedidosOracionRepository;


    @Override
    public List<PedidosOracion> listPedidosOracion() {
        return pedidosOracionRepository.findAll();
    }

    @Override
    public Optional<PedidosOracion> findPedidosOracion(Integer idPedidoOracion) {
        return pedidosOracionRepository.findById(idPedidoOracion);
    }

    @Override
    public PedidosOracion savePedidosOracion(PedidosOracion pedidosOracion) {
        return pedidosOracionRepository.save(pedidosOracion);
    }

    @Override
    public void deletePedidosOracion(Integer idPedidoOracion) {

    }
}
