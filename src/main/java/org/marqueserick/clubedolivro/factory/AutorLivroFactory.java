package org.marqueserick.clubedolivro.factory;

import org.marqueserick.clubedolivro.dto.autorLivro.AutorLivroDtoResposta;
import org.marqueserick.clubedolivro.model.AutorLivro;

import javax.inject.Singleton;

@Singleton
public class AutorLivroFactory {

    public AutorLivroDtoResposta toDto(AutorLivro autorLivro){
        return AutorLivroDtoResposta.builder()
                .livro(new LivroFactory().toDto(autorLivro.getLivro()))
                .autor(new AutorFactory().toDto(autorLivro.getAutor()))
                .build();
    }
}
