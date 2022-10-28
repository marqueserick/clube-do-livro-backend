package org.marqueserick.clubedolivro.dto.cliente;

import lombok.Getter;
import lombok.Setter;
import org.marqueserick.clubedolivro.dto.pessoa.PessoaJuridicaDto;

import javax.json.bind.annotation.JsonbProperty;

@Getter
@Setter
public class ClientePessoaJuridicaDto extends ClienteSalvarDto {

    @JsonbProperty("pessoa")
    private PessoaJuridicaDto pessoa;
}
