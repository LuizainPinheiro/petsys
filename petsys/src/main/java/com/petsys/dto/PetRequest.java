package com.petsys.dto;

import com.petsys.model.PetCategoria;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetRequest {

    @Schema(description = "Nome do pet", example = "Rex")
    private String nome;

    @Schema(description = "Idade do pet em anos", example = "3")
    private Integer idade;

    @Schema(description = "Categoria do Pet (CACHORRO, GATO, COELHO, HAMSTER, OU REPTIL", example = "CACHORRO")
    private PetCategoria categoria;

    @Schema(description = "Id do dono do pet", example = "1")
    private Long donoId;


}
