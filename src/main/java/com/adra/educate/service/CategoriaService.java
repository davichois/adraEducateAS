package com.adra.educate.service;

import com.adra.educate.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    List<Categoria> listCategoria();

    Optional<Categoria> findCategoria(Integer idCategoria);

    Categoria saveCategoria(Categoria categoria);

    void deleteCategoria(Integer idCategoria);

}
