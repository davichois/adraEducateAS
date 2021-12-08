package com.adra.educate.controller;

import com.adra.educate.entity.Capacitacion;
import com.adra.educate.service.CapacitacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("capacitacion")
public class CapacitacionController {

    @Autowired
    CapacitacionService capacitacionService;


    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        Map<String, Object> response = new HashMap<>();

        List<Capacitacion> capacitacions = capacitacionService.listCapacitacion();
        response.put("message", "success");
        response.put("error", "false");
        response.put("body", capacitacions);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int idCapacitacion){
        Map<String, Object> response = new HashMap<>();

        return capacitacionService.findCapacitacion(idCapacitacion).map(capacitacion -> {
            response.put("message", "success");
            response.put("error", "false");
            response.put("body", capacitacion);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }).orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody Capacitacion capacitacion){
        Capacitacion capacitacion1 = capacitacionService.saveCapacitacion(capacitacion);
        return new ResponseEntity<>(capacitacion1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Capacitacion capacitacion, @PathVariable("id") int idCapacitacion){
        Map<String, Object> response = new HashMap<>();
        response.put("message", "success");
        response.put("error", "false");
        response.put("body", "actualizado correctamente");
        capacitacionService.updateCapacitacion(idCapacitacion, capacitacion);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int idCapacitacion) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "success");
        response.put("error", "false");
        response.put("body", "eliminado correctamente");
        capacitacionService.deleteCapacitacion(idCapacitacion);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}

















