package org.marqueserick.clubedolivro.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "autor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_autor")
    private Long id;

    @Column(name = "nome_autor", nullable = false)
    private String nome;

    @ManyToMany
    @JoinTable(
            name = "autor_livro",
            joinColumns = @JoinColumn(name = "cod_autor"),
            inverseJoinColumns = @JoinColumn(name = "cod_livro"))
    private List<Livro> livros;
}
