package com.adra.educate.service.implementation;

import com.adra.educate.entity.Alternativa;
import com.adra.educate.repository.AlternativaRepository;
import com.adra.educate.service.AlternativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlternativaServiceImp implements AlternativaService {

    @Autowired
    private AlternativaRepository alternativaRepository;


    @Override
    public List<Alternativa> listAlternativa() {
        return alternativaRepository.listAlternativa();
    }

    @Override
    public List<Alternativa> listAlternativaByPregunta(Integer idPregunta) {
        return alternativaRepository.listAlternativaPregunta(idPregunta);
    }

    @Override
    public Optional<Alternativa> findAlternativa(Integer idAlternativa) {
        return alternativaRepository.findAlternativa(idAlternativa);
    }

}
