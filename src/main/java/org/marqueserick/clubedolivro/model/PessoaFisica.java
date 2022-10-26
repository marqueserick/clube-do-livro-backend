package org.marqueserick.clubedolivro.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "pf")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PessoaFisica {

    @Id
    @Column(name = "cod_cliente")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "cod_cliente")
    private Cliente cliente;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String rg;
}
