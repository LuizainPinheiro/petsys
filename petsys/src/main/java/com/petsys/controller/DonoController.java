package com.petsys.controller;

import com.petsys.dto.DonoRequest;
import com.petsys.dto.DonoResponse;
import com.petsys.service.DonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donos")
public class DonoController {
    @Autowired
    private DonoService donoService;

    @PostMapping
    public ResponseEntity<DonoResponse> cadastrar(@RequestBody DonoRequest donoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(donoService.cadastrar(donoRequest));
    }

    @GetMapping
    public ResponseEntity<List<DonoResponse>> listar(){
        return ResponseEntity.ok(donoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonoResponse> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(donoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        donoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}