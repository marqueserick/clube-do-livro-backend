package org.marqueserick.clubedolivro.dto.categoriaLivro;

import lombok.*;
import org.marqueserick.clubedolivro.dto.categoria.CategoriaDto;
import org.marqueserick.clubedolivro.dto.livro.LivroDto;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoriaLivroDtoResposta {

    private LivroDto livro;

    private CategoriaDto categoria;
}
