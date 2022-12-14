package org.marqueserick.clubedolivro.dto.categoria;

import lombok.*;

import javax.json.bind.annotation.JsonbProperty;

@Getter
@Setter
public class CategoriaDtoEditar {

    @JsonbProperty("cod_categoria")
    private Long id;


    @JsonbProperty("nome_categoria")
    private String nome;
}
