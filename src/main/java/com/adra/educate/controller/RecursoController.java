package com.adra.educate.controller;

import com.adra.educate.entity.Recurso;
import com.adra.educate.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("recurso")
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        Map<String, Object> response = new HashMap<>();

        List<Recurso> recursos = recursoService.listRecurso();
        response.put("message", "success");
        response.put("error", "false");
        response.put("body", recursos);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/sesion/{idSesion}")
    public ResponseEntity<?> findAllRecursoSesion(@PathVariable("idSesion") int idSesion){
        Map<String, Object> response = new HashMap<>();

        List<Recurso> recursos = recursoService.listRecursoBySesion(idSesion);
        response.put("message", "success");
        response.put("error", "false");
        response.put("body", recursos);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int idRecurso){
        Map<String, Object> response = new HashMap<>();

        return recursoService.findRecurso(idRecurso).map(recurso -> {
            response.put("message", "success");
            response.put("error", "false");
            response.put("body", recurso);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }).orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

}
