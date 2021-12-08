package com.adra.educate.service;

import com.adra.educate.entity.Usuario;
import com.adra.educate.entity.UsuarioReport;

import java.util.List;

public interface UsuarioService {

    void addRolToUsuario(String usuCredencial, String noRol);

    Usuario findByCredencial(String usuCredencial);

    List<Usuario> listUsuario();

    Usuario saveUsuario(String usuCredencial, String pwdCredencial);

    List<UsuarioReport> findAllSocio();

}
