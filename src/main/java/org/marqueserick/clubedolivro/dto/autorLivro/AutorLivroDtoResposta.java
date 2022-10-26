package org.marqueserick.clubedolivro.dto.autorLivro;

import lombok.*;
import org.marqueserick.clubedolivro.dto.autor.AutorDto;
import org.marqueserick.clubedolivro.dto.livro.LivroDto;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AutorLivroDtoResposta {

    private LivroDto livro;
    private AutorDto autor;
}
