package org.marqueserick.clubedolivro.model;

import javax.persistence.*;

@Entity
@Table(name = "categoria_livro")
public class CategoriaLivro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
}
