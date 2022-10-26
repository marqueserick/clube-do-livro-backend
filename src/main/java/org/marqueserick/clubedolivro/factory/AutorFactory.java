package org.marqueserick.clubedolivro.factory;

import org.marqueserick.clubedolivro.dto.autor.AutorDto;
import org.marqueserick.clubedolivro.model.Autor;

import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class AutorFactory {

    public AutorDto toDto(Autor autor){

        return AutorDto.builder()
                .id(autor.getId())
                .nome(autor.getNome())
                .build();
    }

    public AutorDto toDtoDetalhes(Autor autor){

        return AutorDto.builder()
                .id(autor.getId())
                .nome(autor.getNome())
                .livros(new LivroFactory().toDtoList(autor.getLivros()))
                .build();
    }

    public List<AutorDto> toDtoList(List<Autor> autorList){
        return autorList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
