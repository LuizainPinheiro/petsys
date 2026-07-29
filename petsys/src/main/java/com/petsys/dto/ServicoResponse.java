package com.petsys.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServicoResponse {
    private Long id;
    private String descricao;
    private BigDecimal preco;
    private LocalDateTime dtServico;
    private String nomeDoPet;
}