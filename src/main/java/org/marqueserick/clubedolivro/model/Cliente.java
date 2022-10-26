package org.marqueserick.clubedolivro.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cliente")
    private Long id;

    @Column(name = "nome_cliente", nullable = false)
    private String nome;

    @Column(name = "telefone_1",nullable = false)
    private String telefonePrincipal;

    @Column(name = "telefone_2")
    private String telefoneAuxiliar;

    private String email;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Endereco endereco;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PessoaFisica pessoaFisica;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PessoaJuridica pessoaJuridica;


}
