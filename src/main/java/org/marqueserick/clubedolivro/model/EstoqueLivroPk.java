package org.marqueserick.clubedolivro.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class EstoqueLivroPk implements Serializable {

    private static final long serialVersionUID = -6143937267937399840L;

    @Column(name = "cod_livro", unique = true)
    private Long livro;

    @Column(name = "cod_editora")
    private Long editora;
}
