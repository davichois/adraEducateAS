package com.adra.educate.controller;

import com.adra.educate.entity.Alternativa;
import com.adra.educate.entity.Recurso;
import com.adra.educate.service.AlternativaService;
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
@RequestMapping("alternativa")
public class AlternativaController {

    @Autowired
    private AlternativaService alternativaService;


    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        Map<String, Object> response = new HashMap<>();

        List<Alternativa> alternativas = alternativaService.listAlternativa();
        response.put("message", "success");
        response.put("error", "false");
        response.put("body", alternativas);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/sesion/{idPregunta}")
    public ResponseEntity<?> findAllAlternativaPregunta(@PathVariable("idPregunta") int idPregunta){
        Map<String, Object> response = new HashMap<>();

        List<Alternativa> alternativas = alternativaService.listAlternativaByPregunta(idPregunta);
        response.put("message", "success");
        response.put("error", "false");
        response.put("body", alternativas);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int idAlternativa){
        Map<String, Object> response = new HashMap<>();

        return alternativaService.findAlternativa(idAlternativa).map(alternativa -> {
            response.put("message", "success");
            response.put("error", "false");
            response.put("body", alternativa);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }).orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

}
