package org.marqueserick.clubedolivro.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "pedido_livro")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PedidoLivro {

    @EmbeddedId
    PedidoLivroPK id;

    @Column(nullable = false)
    private Integer quantidade;
}
