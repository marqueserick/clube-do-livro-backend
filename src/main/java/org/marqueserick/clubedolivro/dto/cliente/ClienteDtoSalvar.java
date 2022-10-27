package org.marqueserick.clubedolivro.dto.cliente;

import lombok.Getter;
import lombok.Setter;
import org.marqueserick.clubedolivro.dto.endereco.EnderecoDto;
import org.marqueserick.clubedolivro.dto.pessoa.PessoaFisicaDto;
import org.marqueserick.clubedolivro.dto.pessoa.PessoaJuridicaDto;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ClienteDtoSalvar {
    @JsonbProperty("nome_cliente")
    private String nome;

    @Size(max = 15)
    @JsonbProperty("telefone_principal")
    private String telefonePrincipal;

    @Size(max = 15)
    @JsonbProperty("telefone_secundario")
    private String telefoneAuxiliar;

    private String email;

    private EnderecoDto enderecoDto;
    private PessoaFisicaDto pessoaFisica;
    private PessoaJuridicaDto pessoaJuridica;
}
