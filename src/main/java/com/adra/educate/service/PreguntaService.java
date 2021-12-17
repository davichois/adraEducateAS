package com.adra.educate.service;

import com.adra.educate.entity.Pregunta;
import java.util.List;
import java.util.Optional;

public interface PreguntaService {

    List<Pregunta> listPregunta();

    List<Pregunta> listPreguntaByRecurso(Integer idRecurso);

    Optional<Pregunta> findPregunta(Integer idPregunta);

}
