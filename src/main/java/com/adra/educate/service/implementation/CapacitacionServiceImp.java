package com.adra.educate.service.implementation;

import com.adra.educate.entity.Capacitacion;
import com.adra.educate.entity.CapacitacionReport;
import com.adra.educate.repository.CapacitacionReportRepository;
import com.adra.educate.repository.CapacitacionRepository;
import com.adra.educate.service.CapacitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CapacitacionServiceImp implements CapacitacionService {

    @Autowired
    private CapacitacionRepository capacitacionRepository;
    @Autowired
    private CapacitacionReportRepository capacitacionReportRepository;


    @Override
    public List<Capacitacion> listCapacitacion() {
        return capacitacionRepository.listCapacitacion();
    }

    @Override
    public List<Capacitacion> listCapacitacionBancoComunalUsuario(String nuDni) {
        return capacitacionRepository.listCapacitacionBancoComunalUsuario(nuDni);
    }

    @Override
    public Optional<Capacitacion> findCapacitacion(Integer idCapacitacion) {
        return capacitacionRepository.findCapacitacion(idCapacitacion);
    }

    @Override
    public Capacitacion saveCapacitacion(Capacitacion capacitacion) {
        return capacitacionRepository.saveCapacitacion(capacitacion.getNoCapacitacion(), capacitacion.getDeCapacitacion(), capacitacion.getFeInicioCapacitacion(),
                capacitacion.getFeFinCapacitacion(), capacitacion.getTiCapacitacion(), capacitacion.getIdCapCategoria(), capacitacion.getFiImageURL());
    }

    @Override
    public Capacitacion updateCapacitacion(Integer idCapacitacion, Capacitacion capacitacion) {
        return capacitacionRepository.updateCapacitacion(idCapacitacion, capacitacion.getNoCapacitacion(), capacitacion.getDeCapacitacion(),
                capacitacion.getFeInicioCapacitacion(), capacitacion.getFeFinCapacitacion(),capacitacion.getIdCapCategoria(),
                capacitacion.getFiImageURL());
    }

    @Override
    public Capacitacion deleteCapacitacion(Integer idCapacitacion) {
        return capacitacionRepository.deleteCapacitacion(idCapacitacion);
    }

    @Override
    public List<CapacitacionReport> listCapacitacionReport() {
        return capacitacionReportRepository.findAllCapacitacionReport();
    }
}
