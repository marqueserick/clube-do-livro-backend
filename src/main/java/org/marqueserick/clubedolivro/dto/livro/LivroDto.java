package org.marqueserick.clubedolivro.dto.livro;

import io.smallrye.common.constraint.NotNull;
import lombok.*;
import org.marqueserick.clubedolivro.dto.autor.AutorDto;
import org.marqueserick.clubedolivro.dto.categoria.CategoriaDto;
import org.marqueserick.clubedolivro.dto.editora.EditoraDto;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LivroDto {
    @JsonbProperty("cod_livro")
    private Long id;

    @NotNull
    @JsonbProperty("nome_livro")
    private String nome;

    @NotNull
    @JsonbProperty("preco_livro")
    private BigDecimal preco;

    @NotNull
    @Size(max=4, min=4)
    @JsonbProperty("ano_publicacao")
    private Integer anoPublicacao;

    @NotNull
    private String isbn;

    @NotNull
    private EditoraDto editora;

    private List<CategoriaDto> categorias;

    private List<AutorDto> autores;

}
