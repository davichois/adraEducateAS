package com.adra.educate.repository;

import com.adra.educate.entity.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RecursoRepository extends JpaRepository<Recurso, Integer> {

    @Query(value = "CALL SP_LIST_RECURSO", nativeQuery = true)
    List<Recurso> listRecurso();

    @Query(value = "CALL SP_LIST_RECURSO_SESION(:idSesion)", nativeQuery = true)
    List<Recurso> listRecursoBySesion(@Param("idSesion") int idSesion);

    @Query(value = "CALL SP_BUSCAR_RECURSO(:idRecurso)", nativeQuery = true)
    Optional<Recurso> findRecurso(@Param("idRecurso") int idRecurso);

}
