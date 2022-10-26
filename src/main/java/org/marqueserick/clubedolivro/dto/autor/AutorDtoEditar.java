package org.marqueserick.clubedolivro.dto.autor;


import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbProperty;

@Getter
@Setter
public class AutorDtoEditar {

    @JsonbProperty("cod_autor")
    private Long id;

    @JsonbProperty("nome_autor")
    private String nome;
}
