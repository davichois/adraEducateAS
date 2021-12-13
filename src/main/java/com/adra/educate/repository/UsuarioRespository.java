package com.adra.educate.repository;

import com.adra.educate.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRespository extends JpaRepository<Usuario, Integer> {

    Usuario findByUsuCredencial(String usuCredencial);

    @Query(value = "CALL SP_INS_USUARIO(:idUsuPersona, :usuCredencial, :pwdCredencial)", nativeQuery = true)
    Usuario saveUsuario(@Param("idUsuPersona") int idUsuPersona, @Param("usuCredencial") String usuCredencial, @Param("pwdCredencial") String pwdCredencial);

}
