package org.marqueserick.clubedolivro.factory;

import org.marqueserick.clubedolivro.dto.categoriaLivro.CategoriaLivroDtoResposta;
import org.marqueserick.clubedolivro.model.CategoriaLivro;

import javax.inject.Singleton;

@Singleton
public class CategoriaLivroFactory {

    public CategoriaLivroDtoResposta toDto(CategoriaLivro categoriaLivro){
        return CategoriaLivroDtoResposta.builder()
                .livro(new LivroFactory().toDto(categoriaLivro.getLivro()))
                .categoria(new CategoriaFactory().toDto(categoriaLivro.getCategoria()))
                .build();
    }
}
