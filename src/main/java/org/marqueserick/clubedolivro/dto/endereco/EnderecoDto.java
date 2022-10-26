package org.marqueserick.clubedolivro.dto.endereco;

import lombok.*;

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
    private String estado;
    private String cep;
}
