package org.marqueserick.clubedolivro.dto.pessoa;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PessoaJuridicaDto extends PessoaDto {

    private String cnpj;
    private String ie;
}
