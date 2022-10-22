package org.marqueserick.clubedolivro.factory;

import org.marqueserick.clubedolivro.dto.editora.EditoraDto;
import org.marqueserick.clubedolivro.dto.editora.EditoraDtoSalvar;
import org.marqueserick.clubedolivro.dto.editora.EditoraLivroDto;
import org.marqueserick.clubedolivro.model.Editora;

import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class EditoraFactory {

    public Editora toEditora(EditoraLivroDto dto){
        return Editora.builder()
                .id(dto.getId())
                .build();
    }

    public Editora toEditora(EditoraDtoSalvar dto){
        return Editora.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .nomeContato(dto.getNomeContato())
                .telefonePrincipal(dto.getTelefonePrincipal())
                .telefoneAuxiliar(dto.getTelefoneAuxiliar())
                .build();
    }

    public EditoraDto toDto(Editora editora){
        return EditoraDto.builder()
                .id(editora.getId())
                .nome(editora.getNome())
                .email(editora.getEmail())
                .nomeContato(editora.getNomeContato())
                .telefonePrincipal(editora.getTelefonePrincipal())
                .telefoneAuxiliar(editora.getTelefoneAuxiliar())
                .build();
    }

    public EditoraDto toDtoDetalhes(Editora editora){
        return EditoraDto.builder()
                .id(editora.getId())
                .nome(editora.getNome())
                .email(editora.getEmail())
                .nomeContato(editora.getNomeContato())
                .telefonePrincipal(editora.getTelefonePrincipal())
                .telefoneAuxiliar(editora.getTelefoneAuxiliar())
                .livros(new LivroFactory().toDtoList(editora.getLivros()))
                .build();
    }

    public List<EditoraDto> toDtoList(List<Editora> editoras) {
        return editoras.stream().map(this::toDto).collect(Collectors.toList());
    }
}
