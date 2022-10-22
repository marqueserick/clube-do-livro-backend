package org.marqueserick.clubedolivro.dto.livro;

import io.smallrye.common.constraint.NotNull;
import lombok.*;
import org.marqueserick.clubedolivro.dto.editora.EditoraDto;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

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

}
