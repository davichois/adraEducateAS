package com.adra.educate.service.implementation;

import com.adra.educate.entity.Categoria;
import com.adra.educate.repository.CategoriaRepository;
import com.adra.educate.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoriaServiceImp implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    @Override
    public List<Categoria> listCategoria() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> findCategoria(Integer idCategoria) {
        return categoriaRepository.findById(idCategoria);
    }

    @Override
    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void deleteCategoria(Integer idCategoria) {

    }

}
