package com.adra.educate.controller;

import com.adra.educate.entity.Categoria;
import com.adra.educate.entity.PedidosOracion;
import com.adra.educate.service.implementation.PedidosOracionServiceImp;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("pedidosOracion")
public class PedidosOracionController {

    @Autowired
    private PedidosOracionServiceImp pedidosOracionServiceImp;

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        Map<String, Object> response = new HashMap<>();

        List<PedidosOracion> pedidosOracion = pedidosOracionServiceImp.listPedidosOracion();
        response.put("message", "success");
        response.put("error", "false");
        response.put("body", pedidosOracion);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer idPedidosOracion){
        Map<String, Object> response = new HashMap<>();

        return pedidosOracionServiceImp.findPedidosOracion(idPedidosOracion).map(pedido -> {
            response.put("message", "success");
            response.put("error", "false");
            response.put("body", pedido);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }).orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<PedidosOracion> create(@RequestBody PedidosOracion pedidosOracion){
        return new ResponseEntity<>(pedidosOracionServiceImp.savePedidosOracion(pedidosOracion), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Optional<ResponseEntity<PedidosOracion>> update(@RequestBody PedidosOracion pedidosOracion, @PathVariable("id") Integer idPedidosOracion) {
        return this.pedidosOracionServiceImp.findPedidosOracion(idPedidosOracion).map(pedido -> {
            pedido.setDeContenido(pedidosOracion.getDeContenido());
            pedido.setEsPedido(pedidosOracion.getEsPedido());
            pedido.setPersona(pedido.getPersona());
            PedidosOracion resPedido = this.pedidosOracionServiceImp.savePedidosOracion(pedido);
            return new ResponseEntity<>(resPedido, HttpStatus.OK);
        });
    }


}
