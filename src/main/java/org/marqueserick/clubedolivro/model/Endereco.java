package org.marqueserick.clubedolivro.model;

import lombok.*;
import org.marqueserick.clubedolivro.enums.Estado;

import javax.persistence.*;

@Entity
@Table(name = "endereco")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Endereco {

    @Id
    @Column(name = "cod_cliente")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "cod_cliente")
    private Cliente cliente;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String cidade;

    @Column(length = 2, nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    private String cep;
}
