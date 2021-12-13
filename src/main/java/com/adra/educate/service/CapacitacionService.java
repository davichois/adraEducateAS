package com.adra.educate.service;

import com.adra.educate.entity.Capacitacion;
import com.adra.educate.entity.CapacitacionReport;
import com.adra.educate.entity.PersonaReport;

import java.util.List;
import java.util.Optional;

public interface CapacitacionService {

    List<Capacitacion> listCapacitacion();

    List<Capacitacion> listCapacitacionBancoComunalUsuario(String nuDNI);

    Optional<Capacitacion> findCapacitacion(Integer idCapacitacion);

    Capacitacion saveCapacitacion(Capacitacion capacitacion);

    Capacitacion updateCapacitacion(Integer idCapacitacion, Capacitacion capacitacion);

    Capacitacion deleteCapacitacion(Integer idCapacitacion);

    List<CapacitacionReport> listCapacitacionReport();

}
