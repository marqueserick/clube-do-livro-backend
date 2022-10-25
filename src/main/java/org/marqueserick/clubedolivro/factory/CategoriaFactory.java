package org.marqueserick.clubedolivro.factory;

import org.marqueserick.clubedolivro.dto.categoria.CategoriaDto;
import org.marqueserick.clubedolivro.model.Categoria;

import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class CategoriaFactory {

    public Categoria toCategoria(CategoriaDto dto){
        return Categoria.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .build();
    }

    public CategoriaDto toDto(Categoria categoria){
        return CategoriaDto.builder()
                .id(categoria.getId())
                .nome(categoria.getNome())
                .build();
    }

    public CategoriaDto toDtoDetalhes(Categoria categoria){
        return CategoriaDto.builder()
                .id(categoria.getId())
                .nome(categoria.getNome())
                .livros(new LivroFactory().toDtoList(categoria.getLivros()))
                .build();
    }

    public List<CategoriaDto> toDtoList(List<Categoria> categorias){
        return categorias.stream().map(this::toDto).collect(Collectors.toList());
    }
}
