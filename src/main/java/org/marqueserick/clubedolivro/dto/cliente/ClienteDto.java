package org.marqueserick.clubedolivro.dto.cliente;

import lombok.*;
import org.marqueserick.clubedolivro.dto.endereco.EnderecoDto;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ClienteDto {

    @JsonbProperty("cod_cliente")
    private Long id;

    @JsonbProperty("nome_cliente")
    private String nome;

    @Size(max = 15)
    @JsonbProperty("telefone_principal")
    private String telefonePrincipal;

    @Size(max = 15)
    @JsonbProperty("telefone_secundario")
    private String telefoneAuxiliar;

    private String email;
    private EnderecoDto endereco;
}
