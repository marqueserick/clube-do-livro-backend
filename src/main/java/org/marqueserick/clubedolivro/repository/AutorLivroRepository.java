package org.marqueserick.clubedolivro.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.marqueserick.clubedolivro.dto.autorLivro.AutorLivroDto;
import org.marqueserick.clubedolivro.model.Autor;
import org.marqueserick.clubedolivro.model.AutorLivro;
import org.marqueserick.clubedolivro.model.Livro;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AutorLivroRepository implements PanacheRepositoryBase<AutorLivro, Long> {

    public AutorLivro findAutorLivro(AutorLivroDto autotLivroDto) {
        return find("from AutorLivro where cod_livro = ?1 and cod_autor = ?2",
                autotLivroDto.getLivro(),
                autotLivroDto.getAutor())
                .firstResult();
    }

    public AutorLivro adicionar(Livro livro, Autor autor) {
        AutorLivro al = AutorLivro.builder()
                .livro(livro)
                .autor(autor)
                .build();

        persist(al);
        return al;
    }
}
