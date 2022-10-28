package org.marqueserick.clubedolivro.dto.pessoa;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PessoaFisicaDto extends PessoaDto{

    private String cpf;
    private String rg;
}
