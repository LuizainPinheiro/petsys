package com.petsys.dto;

import com.petsys.model.PetCategoria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetResponse {
    private Long id;
    private String nome;
    private PetCategoria categoria;
    private Integer idade;
    private LocalDateTime dtCreated;
    private String donoNome;
}

