package org.marqueserick.clubedolivro.dto.editora;

import lombok.*;
import org.marqueserick.clubedolivro.dto.livro.LivroDto;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EditoraDto {

    @JsonbProperty("cod_editora")
    private Long id;

    @Size(max = 50)
    @JsonbProperty("nome_editora")
    private String nome;

    @Size(max = 15)
    @JsonbProperty("telefone_principal")
    private String telefonePrincipal;

    @Size(max = 15)
    @JsonbProperty("telefone_secundario")
    private String telefoneAuxiliar;

    private String email;

    @JsonbProperty("nome_contato")
    private String nomeContato;

    private List<LivroDto> livros;
}
