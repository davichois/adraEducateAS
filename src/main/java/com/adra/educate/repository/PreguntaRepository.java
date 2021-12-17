package com.adra.educate.repository;

import com.adra.educate.entity.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {

    @Query(value = "CALL SP_LIST_TAX_PREGUNTA", nativeQuery = true)
    List<Pregunta> listPregunta();

    @Query(value = "CALL SP_LIST_TAX_PREGUNTA_RECURSO(:idRecurso)", nativeQuery = true)
    List<Pregunta> listPreguntaByRecurso(@Param("idRecurso") int idRecurso);

    @Query(value = "CALL SP_BUSCAR_TAX_PREGUNTA(:idPregunta)", nativeQuery = true)
    Optional<Pregunta> findPregunta(@Param("idPregunta") int idPregunta);

}
