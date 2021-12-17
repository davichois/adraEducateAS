package com.adra.educate.controller;

import com.adra.educate.entity.Persona;
import com.adra.educate.entity.PersonaReport;
import com.adra.educate.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;


    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        Map<String, Object> response = new HashMap<>();

        List<Persona> personas = personaService.listPersona();

        response.put("message", "success");
        response.put("error", "false");
        response.put("body", personas);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/report")
    public ResponseEntity<?> findAllPersonaReport(){
        Map<String, Object> response = new HashMap<>();

        List<PersonaReport> personasReports = personaService.listPersonaReport();

        response.put("message", "success");
        response.put("error", "false");
        response.put("body", personasReports);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody Persona persona){
        return new ResponseEntity<>(personaService.savePersona(persona), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Persona persona, @PathVariable("id") int idPersona){
        Map<String, Object> response = new HashMap<>();
        response.put("message", "success");
        response.put("error", "false");
        response.put("body", persona);
        personaService.updatePersona(idPersona, persona);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int idPersona){
        Map<String, Object> response = new HashMap<>();
        Persona persona = personaService.deletePersona(idPersona);
        response.put("message", "success");
        response.put("error", "false");
        response.put("body", persona);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
