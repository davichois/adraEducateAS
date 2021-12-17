package com.adra.educate.service.implementation;

import com.adra.educate.entity.Pregunta;
import com.adra.educate.repository.PreguntaRepository;
import com.adra.educate.service.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreguntaServiceImp implements PreguntaService {

    @Autowired
    private PreguntaRepository preguntaRepository;


    @Override
    public List<Pregunta> listPregunta() {
        return preguntaRepository.listPregunta();
    }

    @Override
    public List<Pregunta> listPreguntaByRecurso(Integer idRecurso) {
        return preguntaRepository.listPreguntaByRecurso(idRecurso);
    }

    @Override
    public Optional<Pregunta> findPregunta(Integer idPregunta) {
        return preguntaRepository.findPregunta(idPregunta);
    }
}
