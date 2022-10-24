package org.marqueserick.clubedolivro.factory;

import org.marqueserick.clubedolivro.dto.estoque.EstoqueDto;
import org.marqueserick.clubedolivro.model.Estoque;
import org.marqueserick.clubedolivro.model.EstoqueLivroPk;

import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class EstoqueFactory {

    public EstoqueDto toDto(Estoque estoque){
        return EstoqueDto.builder()
                .livro(estoque.getId().getLivro())
                .editora(estoque.getId().getEditora())
                .quantidade(estoque.getQuantidade())
                .build();
    }

    public Estoque toEstoque(EstoqueDto dto){
        return Estoque.builder()
                .id(new EstoqueLivroPk(dto.getLivro(), dto.getEditora()))
                .quantidade(dto.getQuantidade())
                .build();
    }

    public List<EstoqueDto> toDtoList(List<Estoque> estoqueList){
        return estoqueList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
