package com.adra.educate.controller;

import com.adra.educate.entity.Usuario;
import com.adra.educate.entity.UsuarioReport;
import com.adra.educate.service.UsuarioService;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/")
    public ResponseEntity<List<Usuario>> findAll(){
        return ResponseEntity.ok().body(usuarioService.listUsuario());
    }

    @GetMapping("/statistics")
    public List<UsuarioReport> findAllReport(){
        return usuarioService.findAllSocio();
    }

    @GetMapping("/{credencial}")
    public Usuario findByCredecialInfo(@Param("credencial") String credencial){
        return usuarioService.findByCredencial(credencial);
    }

    @PostMapping("/rol/addtousuario")
    public ResponseEntity<?> addRolToUsuario(@RequestBody RolToUsuarioForm form){
        usuarioService.addRolToUsuario(form.getUsuCredencial(), form.getNoRol());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody Usuario usuario){
        usuarioService.saveUsuario(usuario.getUsuCredencial(), usuario.getPwdCredencial());
        return ResponseEntity.ok().build();
    }

}

@Data
class RolToUsuarioForm{
    private String usuCredencial;
    private String noRol;
}

