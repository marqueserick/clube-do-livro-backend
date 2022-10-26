package org.marqueserick.clubedolivro.dto.editora;

import lombok.*;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class EditoraDtoEditar {
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
}
