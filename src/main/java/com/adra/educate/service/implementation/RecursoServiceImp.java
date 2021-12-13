package com.adra.educate.service.implementation;

import com.adra.educate.entity.Recurso;
import com.adra.educate.repository.RecursoRepository;
import com.adra.educate.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecursoServiceImp implements RecursoService {

    @Autowired
    private RecursoRepository recursoRepository;


    @Override
    public List<Recurso> listRecurso() {
        return recursoRepository.listRecurso();
    }

    @Override
    public List<Recurso> listRecursoBySesion(Integer idSesion) {
        return recursoRepository.listRecursoBySesion(idSesion);
    }

    @Override
    public Optional<Recurso> findRecurso(Integer idRecurso) {
        return recursoRepository.findRecurso(idRecurso);
    }
}
