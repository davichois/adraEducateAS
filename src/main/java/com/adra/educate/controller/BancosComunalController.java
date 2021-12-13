package com.adra.educate.controller;

import com.adra.educate.entity.BancosComunal;
import com.adra.educate.entity.BancosComunalReport;
import com.adra.educate.entity.PersonaReport;
import com.adra.educate.service.BancosComunalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("bancosComunal")
public class BancosComunalController {

    @Autowired
    private BancosComunalService bancosComunalService;


    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        Map<String, Object> response = new HashMap<>();

        List<BancosComunal> bancosComunals = bancosComunalService.listBancoComunal();
        response.put("message", "success");
        response.put("error", "false");
        response.put("body", bancosComunals);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/report")
    public ResponseEntity<?> findAllBancosComunalReport(){
        Map<String, Object> response = new HashMap<>();

        List<BancosComunalReport> bancosComunalReports = bancosComunalService.listBancosComunalReport();

        response.put("message", "success");
        response.put("error", "false");
        response.put("body", bancosComunalReports);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int idBancoComunal){
        Map<String, Object> response = new HashMap<>();

        return bancosComunalService.findBancoComunal(idBancoComunal).map(banco -> {
            response.put("message", "success");
            response.put("error", "false");
            response.put("body", banco);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }).orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody BancosComunal bancosComunal){
        BancosComunal bancosComunal1 = bancosComunalService.saveBancoComunal(bancosComunal);
        return new ResponseEntity<>(bancosComunal1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody BancosComunal bancosComunal, @PathVariable("id") int idBancoComunal){
        Map<String, Object> response = new HashMap<>();
        response.put("message", "success");
        response.put("error", "false");
        response.put("body", "actualizado correctamente");
        bancosComunalService.updateBancoComunal(idBancoComunal, bancosComunal);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int idBancoComunal) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "success");
        response.put("error", "false");
        response.put("body", "eliminado correctamente");
        bancosComunalService.deleteBancoComunal(idBancoComunal);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
