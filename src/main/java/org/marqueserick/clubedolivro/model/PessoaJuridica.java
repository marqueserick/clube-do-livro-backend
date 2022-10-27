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
public class PessoaJuridica extends Pessoa {

    @Id
    @Column(name = "cod_cliente")
    private Long id;

    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String ie;
}
