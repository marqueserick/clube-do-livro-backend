package org.marqueserick.clubedolivro.model;

import lombok.*;
import org.marqueserick.clubedolivro.enums.StatusPedido;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_pedido")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cod_cliente")
    private Cliente cliente;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_pedido", nullable = false)
    private Date data;

    @Column(name = "valor_pedido", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "status_pedido", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @ManyToMany
    @JoinTable(
            name = "item_pedido",
            joinColumns = @JoinColumn(name = "cod_pedido"),
            inverseJoinColumns = @JoinColumn(name = "cod_livro")
    )
    private List<Livro> livros;

}
