package org.marqueserick.clubedolivro.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "livro")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_livro")
    private Long id;

    @Column(name = "nome_livro", nullable = false)
    private String nome;

    @Column(name = "preco_livro", precision = 5, scale = 2, nullable = false)
    private BigDecimal preco;


    @Column(name = "ano_publicacao", nullable = false)
    private Integer anoPublicacao;

    @Column(nullable = false, unique = true)
    private String isbn;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cod_editora", nullable = false)
    private Editora editora;

    @ManyToMany(mappedBy = "livros")
    private List<Categoria> categorias;

    @ManyToMany(mappedBy = "livros")
    private List<Autor> autores;


}
