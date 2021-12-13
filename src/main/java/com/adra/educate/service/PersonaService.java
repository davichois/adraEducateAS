package com.adra.educate.service;

import com.adra.educate.entity.Persona;
import com.adra.educate.entity.PersonaReport;

import java.util.List;

public interface PersonaService {

    List<Persona> listPersona();

    Persona savePersona(Persona persona);

    Persona updatePersona(Integer idPersona, Persona persona);

    List<PersonaReport> listPersonaReport();

}
