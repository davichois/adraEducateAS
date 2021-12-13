package com.adra.educate.service;

import com.adra.educate.entity.Recurso;

import java.util.List;
import java.util.Optional;

public interface RecursoService {

    List<Recurso> listRecurso();

    List<Recurso> listRecursoBySesion(Integer idSesion);

    Optional<Recurso> findRecurso(Integer idRecurso);

}
