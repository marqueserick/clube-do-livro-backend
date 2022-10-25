package org.marqueserick.clubedolivro.factory;

import org.marqueserick.clubedolivro.dto.categoria.CategoriaLivroDtoDetalhes;
import org.marqueserick.clubedolivro.model.CategoriaLivro;

import javax.inject.Singleton;

@Singleton
public class CategoriaLivroFactory {

    public CategoriaLivroDtoDetalhes toDto(CategoriaLivro categoriaLivro){
        return CategoriaLivroDtoDetalhes.builder()
                .livro(new LivroFactory().toDto(categoriaLivro.getLivro()))
                .categoria(new CategoriaFactory().toDto(categoriaLivro.getCategoria()))
                .build();
    }
}
