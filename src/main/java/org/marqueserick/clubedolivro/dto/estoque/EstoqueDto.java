package org.marqueserick.clubedolivro.dto.estoque;

import lombok.*;

import javax.json.bind.annotation.JsonbProperty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstoqueDto {

    @JsonbProperty("cod_livro")
    private Long livro;

    @JsonbProperty("cod_editora")
    private Long editora;

    private Integer quantidade;
}
