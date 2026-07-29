package com.petsys.controller;

import com.petsys.dto.PetRequest;
import com.petsys.dto.PetResponse;
import com.petsys.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    public ResponseEntity<PetResponse> cadastrar(@RequestBody PetRequest pet){
        PetResponse petSalvo = petService.cadastrar(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(petSalvo);
    }

    @GetMapping
    public ResponseEntity<List<PetResponse>> listar(
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) String nome
    ){
        return ResponseEntity.ok(petService.listar(categoria, nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetResponse> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(petService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        petService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}