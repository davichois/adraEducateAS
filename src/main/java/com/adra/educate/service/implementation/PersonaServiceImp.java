package com.adra.educate.service.implementation;

import com.adra.educate.entity.Persona;
import com.adra.educate.repository.PersonaRepository;
import com.adra.educate.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImp implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;


    @Override
    public List<Persona> listPersona() {
        return personaRepository.listPersona();
    }

    @Override
    public Persona savePersona(Persona persona) {
        return personaRepository.savePersona(persona.getNoPersona(), persona.getApPaterno(), persona.getApMaterno(),
                persona.getNuTelefono(), persona.getNuDNI(), persona.getDiPersona(), persona.getTiSexo(), persona.getIdBancoComunal());
    }

    @Override
    public Persona updatePersona(Integer idPersona, Persona persona) {
        return personaRepository.updatePersona(idPersona, persona.getNoPersona(), persona.getApPaterno(), persona.getApMaterno(),
                persona.getNuTelefono(), persona.getDiPersona(), persona.getTiSexo(), persona.getIdBancoComunal());
    }

}
