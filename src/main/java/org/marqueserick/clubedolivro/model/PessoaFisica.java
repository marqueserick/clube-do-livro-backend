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
public class PessoaFisica extends Pessoa{

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String rg;
}
