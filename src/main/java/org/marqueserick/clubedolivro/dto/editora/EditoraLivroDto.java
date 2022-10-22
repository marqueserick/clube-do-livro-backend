package org.marqueserick.clubedolivro.dto.editora;

import io.smallrye.common.constraint.NotNull;
import lombok.*;

import javax.json.bind.annotation.JsonbProperty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditoraLivroDto {

    @NotNull
    @JsonbProperty("cod_editora")
    private Long id;
}
