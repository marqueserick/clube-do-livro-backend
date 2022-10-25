package org.marqueserick.clubedolivro.dto.categoria;

import lombok.*;
import org.marqueserick.clubedolivro.dto.livro.LivroDto;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoriaLivroDtoDetalhes {

    private LivroDto livro;

    private CategoriaDto categoria;
}
