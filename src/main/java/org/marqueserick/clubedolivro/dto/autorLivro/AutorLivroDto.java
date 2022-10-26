package org.marqueserick.clubedolivro.dto.autorLivro;

import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbProperty;

@Getter
@Setter
public class AutorLivroDto {

    @JsonbProperty("cod_livro")
    private Long livro;

    @JsonbProperty("cod_autor")
    private Long autor;
}
