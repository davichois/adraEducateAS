package com.adra.educate.controller;

import com.adra.educate.entity.Categoria;
import com.adra.educate.service.CategoriaService;
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

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        Map<String, Object> response = new HashMap<>();

        List<Categoria> categorias = categoriaService.listCategoria();
        response.put("message", "success");
        response.put("error", "false");
        response.put("body", categorias);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer idCategoria){
        Map<String, Object> response = new HashMap<>();

        return categoriaService.findCategoria(idCategoria).map(categoria -> {
            response.put("message", "success");
            response.put("error", "false");
            response.put("body", categoria);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }).orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){
        return new ResponseEntity<>(categoriaService.saveCategoria(categoria), HttpStatus.CREATED);
    }

    @PostMapping("/excell")
    public ResponseEntity<?> importExcelFile(@RequestParam("file") MultipartFile files) throws IOException {
        Map<String, Object> response = new HashMap<>();
        HttpStatus status = HttpStatus.OK;

        List<Categoria> categoriaList = new ArrayList<>();
        List<Categoria> saveCategoria = new ArrayList<>();

        XSSFWorkbook workbook = new XSSFWorkbook(files.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);

        for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
            if (index > 0) {
                Categoria categoria = new Categoria();
                XSSFRow row = worksheet.getRow(index);

                categoria.setNoCategoria(row.getCell(1).getStringCellValue());

                categoriaList.add(categoria);
            }
        }

        for (Categoria data: categoriaList){
            Categoria categoria = categoriaService.saveCategoria(data);
            saveCategoria.add(categoria);
        }

        response.put("message", "success");
        response.put("error", "false");
        response.put("body", saveCategoria);

        return new ResponseEntity<Map<String, Object>>(response, status);
    }

    @PutMapping("/{id}")
    public Optional<ResponseEntity<Categoria>> update(@RequestBody Categoria categoria, @PathVariable("id") Integer idCategoria) {
        return this.categoriaService.findCategoria(idCategoria).map(category -> {
            category.setNoCategoria(categoria.getNoCategoria());
            category.setCapacitacions(category.getCapacitacions());
            Categoria resCategory = this.categoriaService.saveCategoria(category);
            return new ResponseEntity<>(resCategory, HttpStatus.OK);
        });
    }

}
