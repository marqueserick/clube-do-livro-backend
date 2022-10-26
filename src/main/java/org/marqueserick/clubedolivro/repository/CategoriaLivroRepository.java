package org.marqueserick.clubedolivro.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.marqueserick.clubedolivro.dto.categoriaLivro.CategoriaLivroDto;
import org.marqueserick.clubedolivro.model.Categoria;
import org.marqueserick.clubedolivro.model.CategoriaLivro;
import org.marqueserick.clubedolivro.model.Livro;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoriaLivroRepository implements PanacheRepositoryBase<CategoriaLivro, Long> {
    public CategoriaLivro findCategoriaLivro(CategoriaLivroDto categoriaLivroDto) {
        return find("from CategoriaLivro where cod_livro = ?1 and cod_categoria = ?2",
                categoriaLivroDto.getLivro(),
                categoriaLivroDto.getCategoria())
                .firstResult();
    }

    public CategoriaLivro adicionar(Livro livro, Categoria categoria) {
        CategoriaLivro cl = CategoriaLivro.builder()
                .categoria(categoria)
                .livro(livro)
                .build();
        persist(cl);
        return cl;
    }
}
