package org.marqueserick.clubedolivro.dto.endereco;

import lombok.*;
import org.marqueserick.clubedolivro.enums.Estado;

import javax.json.bind.annotation.JsonbProperty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EnderecoDto {


    @JsonbProperty("residencia")
    private String endereco;
    private String bairro;
    private String cidade;
    private Estado estado;
    private String cep;
}
