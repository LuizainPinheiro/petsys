package com.petsys.service;

import com.petsys.dto.ServicoRequest;
import com.petsys.dto.ServicoResponse;
import com.petsys.model.Pet;
import com.petsys.model.Servico;
import com.petsys.repository.PetRepository;
import com.petsys.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private PetRepository petRepository;

    public ServicoResponse cadastrar(ServicoRequest servicoRequest) {
        Pet pet = petRepository.findById(servicoRequest.getPetId())
                .orElseThrow(() -> new IllegalArgumentException("Pet não encontrado com id: " + servicoRequest.getPetId()));

        Servico servico = Servico.builder()
                .descricao(servicoRequest.getDescricao())
                .preco(servicoRequest.getPreco())
                .pet(pet)
                .build();

        Servico servicoSalvo = servicoRepository.save(servico);

        return toResponse(servicoSalvo);
    }

    public List<ServicoResponse> listar() {
        return servicoRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public ServicoResponse buscarPorId(Long id) {
        Servico servico = servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado com id: " + id));

        return toResponse(servico);
    }

    public void deletar(Long id) {
        if (!servicoRepository.existsById(id)) {
            throw new RuntimeException("Serviço não encontrado com id: " + id);
        }
        servicoRepository.deleteById(id);
    }

    private ServicoResponse toResponse(Servico servico) {
        return ServicoResponse.builder()
                .id(servico.getId())
                .descricao(servico.getDescricao())
                .preco(servico.getPreco())
                .dtServico(servico.getDtServico())
                .nomeDoPet(servico.getPet().getNome())
                .build();
    }
}