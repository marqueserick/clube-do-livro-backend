package org.marqueserick.clubedolivro.dto.autor;

import lombok.*;
import org.marqueserick.clubedolivro.dto.livro.LivroDto;

import javax.json.bind.annotation.JsonbProperty;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AutorDto {

    @JsonbProperty("cod_autor")
    private Long id;

    @JsonbProperty("nome_autor")
    private String nome;

    private List<LivroDto> livros;
}
