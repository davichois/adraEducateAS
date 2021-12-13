package com.adra.educate.service.implementation;

import com.adra.educate.entity.Rol;
import com.adra.educate.entity.Usuario;
import com.adra.educate.entity.UsuarioReport;
import com.adra.educate.repository.RolRepository;
import com.adra.educate.repository.UsuarioReportRepository;
import com.adra.educate.repository.UsuarioRespository;
import com.adra.educate.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @Transactional @Slf4j
public class UsuarioServiceImp implements UsuarioService, UserDetailsService {

    @Autowired
    private UsuarioRespository usuarioRespository;
    @Autowired
    private RolRepository rolRespository;
    @Autowired
    private UsuarioReportRepository usuarioReportRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String usuCredencial) throws UsernameNotFoundException {
        Usuario usuario = usuarioRespository.findByUsuCredencial(usuCredencial);
        if (usuario == null){
            log.error("Usuario no existe en la Aplicacion");
            throw new UsernameNotFoundException("Usuario no se encontro en la db");
        } else {
            log.info("Usuario si existe en la base de datos {}", usuCredencial);
        }

        // Sacando los roles del usuario
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        usuario.getRols().forEach(rol -> {
            authorities.add(new SimpleGrantedAuthority(rol.getNoRol()));
            }
        );

        return new User(usuario.getUsuCredencial(), usuario.getPwdCredencial(), authorities);
    }

    @Override
    public void addRolToUsuario(String usuCredencial, String noRol) {
        Usuario usuario = usuarioRespository.findByUsuCredencial(usuCredencial);
        Rol rol = rolRespository.findByNoRol(noRol);
        log.info("Asignando rol {} al usuario {}", noRol, usuCredencial);
        usuario.getRols().add(rol);
    }

    @Override
    public Usuario findByCredencial(String usuCredencial) {
        log.info("Trayendo usuario {}", usuCredencial);
        return usuarioRespository.findByUsuCredencial(usuCredencial);
    }

    @Override
    public List<Usuario> listUsuario() {
        log.info("Trayendo todos los usuarios");
        return usuarioRespository.findAll();
    }


    @Override
    public Usuario saveUsuario(Integer idUsuPersona, String usuCredencial, String pwdCredencial) {
        log.info("Usuario nuevo agregado {}", usuCredencial);
        return usuarioRespository.saveUsuario(idUsuPersona, usuCredencial, passwordEncoder.encode(pwdCredencial));
    }

    @Override
    public List<UsuarioReport> findAllSocio() {
        log.info("trayendo reportes");
        return usuarioReportRepository.findAllSocioReport();
    }
}
