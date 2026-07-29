package com.petsys.service;

import com.petsys.dto.PetRequest;
import com.petsys.dto.PetResponse;
import com.petsys.model.Dono;
import com.petsys.model.Pet;
import com.petsys.model.PetCategoria;
import com.petsys.repository.DonoRepository;
import com.petsys.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private DonoRepository donoRepository;

    public PetResponse cadastrar(PetRequest petRequest) {
        Dono dono = donoRepository.findById(petRequest.getDonoId())
                .orElseThrow(() -> new IllegalArgumentException("Dono não encontrado com o id: " + petRequest.getDonoId()));

        Pet pet = Pet.builder()
                .nome(petRequest.getNome())
                .categoria(petRequest.getCategoria())
                .idade(petRequest.getIdade())
                .dono(dono)
                .build();

        Pet petSalvo = petRepository.save(pet);

        return toResponse(petSalvo);
    }

    public List<PetResponse> listar(String categoria, String nome){

        List<Pet> pets;

        if(categoria != null && !categoria.isBlank()) {
            pets = petRepository.findByCategoria(PetCategoria.valueOf(categoria.toUpperCase()));

        } else if(nome != null && !nome.isBlank()){
            pets = petRepository.findByNomeContainingIgnoreCase(nome);

        } else {
            pets = petRepository.findAll();
        }

        return pets.stream()
                .map(p -> toResponse(p))
                .toList();
    }

    private PetResponse toResponse(Pet pet) {
        return PetResponse.builder()
        .id(pet.getId())
        .nome(pet.getNome())
        .idade(pet.getIdade())
        .categoria(pet.getCategoria())
        .dtCreated(pet.getDtCreated())
        .donoNome(pet.getDono().getNome())
        .build();
    }

    public PetResponse buscarPorId(Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado com id: " + id));

        return toResponse(pet);
    }

    public void deletar(Long id) {
        if (!petRepository.existsById(id)) {
            throw new RuntimeException("Pet não encontrado com id: " + id);
        }
        petRepository.deleteById(id);
    }


}