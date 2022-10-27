package org.marqueserick.clubedolivro.dto.pessoa;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PessoaJuridicaDto {

    private String cnpj;
    private String ie;
}
