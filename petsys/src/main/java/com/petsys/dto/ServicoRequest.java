package com.petsys.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServicoRequest {

    @Schema(description = "Id do pet", example = "2")
    private Long petId;

    @Schema(description = "Descrição do serviço", example = "Tosa higiênica")
    private String descricao;

    @Schema(description = "Preço do serviço", example = "40.00")
    private BigDecimal preco;
}