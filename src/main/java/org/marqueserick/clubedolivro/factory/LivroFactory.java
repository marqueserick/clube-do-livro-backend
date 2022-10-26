package org.marqueserick.clubedolivro.factory;

import org.marqueserick.clubedolivro.dto.livro.LivroDto;
import org.marqueserick.clubedolivro.dto.livro.LivroDtoSalvar;
import org.marqueserick.clubedolivro.model.Livro;

import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class LivroFactory {
    public LivroDto toDto(Livro livro){
        return LivroDto.builder()
                .id(livro.getId())
                .nome(livro.getNome())
                .preco(livro.getPreco())
                .anoPublicacao(livro.getAnoPublicacao())
                .isbn(livro.getIsbn())
                .build();
    }

    public LivroDto toDtoDetalhes(Livro livro){
        return LivroDto.builder()
                .id(livro.getId())
                .nome(livro.getNome())
                .preco(livro.getPreco())
                .anoPublicacao(livro.getAnoPublicacao())
                .isbn(livro.getIsbn())
                .editora(new EditoraFactory().toDto(livro.getEditora()))
                .categorias(new CategoriaFactory().toDtoList(livro.getCategorias()))
                .autores(new AutorFactory().toDtoList(livro.getAutores()))
                .build();
    }

    public Livro toLivro(LivroDtoSalvar dto){
        return Livro.builder()
                .nome(dto.getNome())
                .preco(dto.getPreco())
                .anoPublicacao(dto.getAnoPublicacao())
                .isbn(dto.getIsbn())
                .editora(new EditoraFactory().toEditora(dto.getEditora()))
                .build();
    }

    public List<LivroDto> toDtoList(List<Livro> livros){
        return livros.stream().map(this::toDto).collect(Collectors.toList());
    }
}
