package org.marqueserick.clubedolivro.dto.categoria;


import lombok.*;

import javax.json.bind.annotation.JsonbProperty;

@Getter
@Setter
public class CategoriaDtoSalvar {

    @JsonbProperty("nome_categoria")
    private String nome;
}
