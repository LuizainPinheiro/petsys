package com.petsys.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DonoRequest {

    @Schema(description = "Nome do Dono", example = "Luiza")
    private String nome;

    @Schema(description = "Número de telefone", example = "40028922")
    private String telefone;

    @Schema(description = "Endereço de email", example = "luiza@email.com")
    private String email;
}
