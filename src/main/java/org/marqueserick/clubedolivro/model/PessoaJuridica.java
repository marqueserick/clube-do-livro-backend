package org.marqueserick.clubedolivro.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "pj")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PessoaJuridica {

    @Id
    @Column(name = "cod_cliente")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "cod_cliente")
    private Cliente cliente;

    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String ie;
}
