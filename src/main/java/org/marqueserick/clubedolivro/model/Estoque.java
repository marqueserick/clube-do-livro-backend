package org.marqueserick.clubedolivro.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "estoque")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Estoque {

    @EmbeddedId
    private EstoqueLivroPk id;

    @Column(nullable = false)
    private Integer quantidade;
}
