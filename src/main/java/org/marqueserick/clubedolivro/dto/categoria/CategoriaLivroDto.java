package org.marqueserick.clubedolivro.dto.categoria;

import lombok.*;
import org.marqueserick.clubedolivro.dto.livro.LivroDto;

import javax.json.bind.annotation.JsonbProperty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoriaLivroDto {

    @JsonbProperty("cod_livro")
    private Long livro;

    @JsonbProperty("cod_categoria")
    private Long categoria;
}
