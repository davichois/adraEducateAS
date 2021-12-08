package com.adra.educate.repository;

import com.adra.educate.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    @Query(value = "CALL SP_LIST_PERSONA;", nativeQuery = true)
    List<Persona> listPersona();

    @Query(value = "CALL SP_INS_PERSONA(:noPersona, :apPaterno, :apMaterno, :nuTelefono, :nuDNI, :diPersona, :tiSexo, :idBancoComunal)", nativeQuery = true)
    Persona savePersona(
            @Param("noPersona") String noPersona, @Param("apPaterno") String apPaterno, @Param("apMaterno") String apMaterno, @Param("nuTelefono") String nuTelefono,
            @Param("nuDNI") String nuDNI,           @Param("diPersona") String diPersona, @Param("tiSexo") char tiSexo,         @Param("idBancoComunal") int idBancoComunal
    );

    @Query(value = "CALL SP_UPD_PERSONA(:idPersona, :noPersona, :apPaterno, :apMaterno, :nuTelefono, :diPersona, :tiSexo, :idBancoComunal)", nativeQuery = true)
    Persona updatePersona(
            @Param("idPersona") int idPersona,       @Param("noPersona") String noPersona,   @Param("apPaterno") String apPaterno,    @Param("apMaterno") String apMaterno,
            @Param("nuTelefono") String nuTelefono,  @Param("diPersona") String diPersona,   @Param("tiSexo") char tiSexo,            @Param("idBancoComunal") int idBancoComunal
    );

}
