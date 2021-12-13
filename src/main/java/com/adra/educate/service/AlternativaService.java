package com.adra.educate.service;

import com.adra.educate.entity.Alternativa;

import java.util.List;
import java.util.Optional;

public interface AlternativaService {

    List<Alternativa> listAlternativa();

    List<Alternativa> listAlternativaByPregunta(Integer idPregunta);

    Optional<Alternativa> findAlternativa(Integer idAlternativa);

}
