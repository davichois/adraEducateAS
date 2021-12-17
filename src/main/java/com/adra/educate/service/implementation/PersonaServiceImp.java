package com.adra.educate.service.implementation;

import com.adra.educate.entity.Persona;
import com.adra.educate.entity.PersonaReport;
import com.adra.educate.repository.PersonaReportRepository;
import com.adra.educate.repository.PersonaRepository;
import com.adra.educate.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonaServiceImp implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private PersonaReportRepository personaReportRepository;


    @Override
    public List<Persona> listPersona() {
        return personaRepository.listPersona();
    }

    @Override
    public Persona savePersona(Persona persona) {
        return personaRepository.savePersona(persona.getNoPersona(), persona.getApPaterno(), persona.getApMaterno(),
                persona.getNuTelefono(), persona.getNuDNI(), persona.getDiPersona(), persona.getTiSexo(), persona.getIdBancoComunal());
        // usuarioService.saveUsuario(persona.getNuDNI(), persona.getNuDNI());
    }

    @Override
    public Persona updatePersona(Integer idPersona, Persona persona) {
        return personaRepository.updatePersona(idPersona, persona.getNoPersona(), persona.getApPaterno(), persona.getApMaterno(),
                persona.getNuTelefono(), persona.getDiPersona(), persona.getTiSexo(), persona.getIdBancoComunal());
    }

    @Override
    public List<PersonaReport> listPersonaReport() {
        log.info("trayendo report de persona");
        return personaReportRepository.findAllPersonaReport();
    }

    @Override
    public Persona deletePersona(Integer idPersona) {
        return personaRepository.deletePersona(idPersona);
    }

}
