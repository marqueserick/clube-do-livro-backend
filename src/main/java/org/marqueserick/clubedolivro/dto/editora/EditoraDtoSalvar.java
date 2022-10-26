package org.marqueserick.clubedolivro.dto.editora;

import io.smallrye.common.constraint.NotNull;
import lombok.*;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class EditoraDtoSalvar {

    @NotNull
    @Size(max = 50)
    @JsonbProperty("nome_editora")
    private String nome;

    @NotNull
    @Size(max = 15)
    @JsonbProperty("telefone_principal")
    private String telefonePrincipal;

    @Size(max = 15)
    @JsonbProperty("telefone_secundario")
    private String telefoneAuxiliar;

    @NotNull
    private String email;

    @NotNull
    @JsonbProperty("nome_contato")
    private String nomeContato;
}
