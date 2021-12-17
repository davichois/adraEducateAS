package com.adra.educate.controller;

import com.adra.educate.entity.Pregunta;
import com.adra.educate.service.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("pregunta")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;


    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        Map<String, Object> response = new HashMap<>();

        List<Pregunta> preguntas = preguntaService.listPregunta();
        response.put("message", "success");
        response.put("error", "false");
        response.put("body", preguntas);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/recurso/{idRecurso}")
    public ResponseEntity<?> findAllPreguntaRecurso(@PathVariable("idRecurso") int idRecurso){
        Map<String, Object> response = new HashMap<>();

        List<Pregunta> preguntas = preguntaService.listPreguntaByRecurso(idRecurso);
        response.put("message", "success");
        response.put("error", "false");
        response.put("body", preguntas);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int idPregunta){
        Map<String, Object> response = new HashMap<>();

        return preguntaService.findPregunta(idPregunta).map(pregunta -> {
            response.put("message", "success");
            response.put("error", "false");
            response.put("body", pregunta);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }).orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

}
