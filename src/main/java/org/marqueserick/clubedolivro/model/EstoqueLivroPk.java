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
public class EstoqueLivroPk implements Serializable {

    private static final long serialVersionUID = -6143937267937399840L;

    @Column(name = "cod_livro")
    private Long livro;

    @Column(name = "cod_editora")
    private Long editora;
}
