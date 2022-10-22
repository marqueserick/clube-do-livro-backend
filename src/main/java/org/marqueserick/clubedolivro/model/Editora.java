package org.marqueserick.clubedolivro.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "editora")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_editora")
    private Long id;

    @Column(name = "nome_editora", nullable = false)
    private String nome;

    @Column(name = "telefone_1", nullable = false, length = 15)
    private String telefonePrincipal;

    @Column(name = "telefone_2", nullable = true, length = 15)
    private String telefoneAuxiliar;

    @Column(nullable = false)
    private String email;

    @Column(name = "contato", nullable = false, length = 50)
    private String nomeContato;

    @OneToMany(mappedBy = "editora")
    private List<Livro> livros;
}
