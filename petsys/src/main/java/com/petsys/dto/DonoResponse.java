package com.petsys.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DonoResponse {

    private Long id;
    private String nome;
    private String telefone;
    private List<String> pets;

}
