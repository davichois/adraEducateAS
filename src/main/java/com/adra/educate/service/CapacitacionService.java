package com.adra.educate.service;

import com.adra.educate.entity.Capacitacion;

import java.util.List;
import java.util.Optional;

public interface CapacitacionService {

    List<Capacitacion> listCapacitacion();

    Optional<Capacitacion> findCapacitacion(Integer idCapacitacion);

    Capacitacion saveCapacitacion(Capacitacion capacitacion);

    Capacitacion updateCapacitacion(Integer idCapacitacion, Capacitacion capacitacion);

    Capacitacion deleteCapacitacion(Integer idCapacitacion);

}
