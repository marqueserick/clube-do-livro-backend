package org.marqueserick.clubedolivro.dto.categoriaLivro;

import lombok.*;

import javax.json.bind.annotation.JsonbProperty;

@Getter
@Setter
public class CategoriaLivroDto {

    @JsonbProperty("cod_livro")
    private Long livro;

    @JsonbProperty("cod_categoria")
    private Long categoria;
}
