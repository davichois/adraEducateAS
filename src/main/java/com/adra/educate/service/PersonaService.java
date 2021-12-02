package com.adra.educate.service;

import com.adra.educate.entity.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {

    List<Persona> listPersona();

    Persona savePersona(Persona persona);

    Persona updatePersona(Integer idPersona, Persona persona);

}
