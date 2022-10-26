package org.marqueserick.clubedolivro.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categoria")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Categoria {

    @Id
    @Column(name = "cod_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_categoria", nullable = false)
    private String nome;

    @ManyToMany
    @JoinTable(
            name = "categoria_livro",
            joinColumns = @JoinColumn(name = "cod_categoria"),
            inverseJoinColumns = @JoinColumn(name = "cod_livro"))
    private List<Livro> livros;
}
