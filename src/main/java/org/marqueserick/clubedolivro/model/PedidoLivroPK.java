package org.marqueserick.clubedolivro.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PedidoLivroPK implements Serializable {
    private static final long serialVersionUID = -5686483432418654270L;

    @MapsId
    @ManyToOne
    @JoinColumn(name = "cod_livro")
    private Livro livro;

    @MapsId
    @ManyToOne
    @JoinColumn(name = "cod_pedido")
    private Pedido pedido;
}
