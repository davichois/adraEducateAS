package com.adra.educate.repository;

import com.adra.educate.entity.Alternativa;
import com.adra.educate.entity.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AlternativaRepository extends JpaRepository<Alternativa, Integer> {

    @Query(value = "CALL SP_LIST_TAX_ALTERNATIVA", nativeQuery = true)
    List<Alternativa> listAlternativa();

    @Query(value = "CALL SP_LIST_TAX_ALTERNATIVA_PREGUNTA(:idPregunta)", nativeQuery = true)
    List<Alternativa> listAlternativaPregunta(@Param("idPregunta") int idPregunta);

    @Query(value = "CALL SP_BUSCAR_TAX_ALTERNATIVA(:idAlternativa)", nativeQuery = true)
    Optional<Alternativa> findAlternativa(@Param("idAlternativa") int idAlternativa);

}
