package org.marqueserick.clubedolivro.dto.categoria;

import lombok.*;
import org.marqueserick.clubedolivro.dto.livro.LivroDto;

import javax.json.bind.annotation.JsonbProperty;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoriaDto {

    @JsonbProperty("cod_categoria")
    private Long id;

    @JsonbProperty("nome_categoria")
    private String nome;

    private List<LivroDto> livros;
}
