package org.marqueserick.clubedolivro.dto.cliente;

import lombok.Getter;
import lombok.Setter;
import org.marqueserick.clubedolivro.dto.pessoa.PessoaFisicaDto;

import javax.json.bind.annotation.JsonbProperty;

@Getter
@Setter
public class ClientePessoaFisicaDto extends ClienteSalvarDto {

    @JsonbProperty("pessoa")
    private PessoaFisicaDto pessoa;
}
