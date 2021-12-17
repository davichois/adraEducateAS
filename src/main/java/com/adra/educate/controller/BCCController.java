package com.adra.educate.controller;

import com.adra.educate.entity.BCC;
import com.adra.educate.entity.Persona;
import com.adra.educate.service.BCCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("bcc")
public class BCCController {

    @Autowired
    private BCCService bccService;


    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody BCC bcc){
        return new ResponseEntity<>(bccService.saveBCC(bcc.getIdBanco(), bcc.getIdCapacitacion()), HttpStatus.CREATED);
    }

}
