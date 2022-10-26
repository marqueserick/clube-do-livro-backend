package org.marqueserick.clubedolivro.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "autor_livro")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AutorLivro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "cod_livro")
    private Livro livro;


    @ManyToOne
    @JoinColumn(name = "cod_autor")
    private Autor autor;
}
