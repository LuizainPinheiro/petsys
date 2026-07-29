package com.petsys.service;

import com.petsys.dto.DonoRequest;
import com.petsys.dto.DonoResponse;
import com.petsys.model.Dono;
import com.petsys.repository.DonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DonoService {

    @Autowired
    private DonoRepository donoRepository;

    public DonoResponse cadastrar(DonoRequest donoRequest){
        Dono dono = Dono.builder()
                .nome(donoRequest.getNome())
                .telefone(donoRequest.getTelefone())
                .email(donoRequest.getEmail())
                .build();

        Dono saved = donoRepository.save(dono);

        return toReponseDTO(saved);
    }

    public List<DonoResponse> listar(){
        List<Dono> donos = donoRepository.findAll();
        return donos.stream().map(d -> toReponseDTO(d)).toList();
    }

    public DonoResponse buscarPorId(Long id) {
        Dono dono = donoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dono não encontrado com id: " + id));

        return toReponseDTO(dono);
    }

    public void deletar(Long id) {
        if (!donoRepository.existsById(id)) {
            throw new RuntimeException("Dono não encontrado com id: " + id);
        }
        donoRepository.deleteById(id);
    }

    private DonoResponse toReponseDTO(Dono dono){
        List<String> nomePets = dono.getPets() != null
                ? dono.getPets().stream().map(i -> i.getNome()).toList()
                : Collections.emptyList();

        return DonoResponse.builder()
                .id(dono.getId())
                .nome(dono.getNome())
                .telefone(dono.getTelefone())
                .pets(nomePets)
                .build();
    }
}