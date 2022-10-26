package org.marqueserick.clubedolivro.factory;

import org.marqueserick.clubedolivro.dto.endereco.EnderecoDto;
import org.marqueserick.clubedolivro.model.Endereco;

import javax.inject.Singleton;

@Singleton
public class EnderecoFactory {

    public EnderecoDto toDto(Endereco endereco){
        return EnderecoDto.builder()
                .endereco(endereco.getEndereco())
                .bairro(endereco.getBairro())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .cep(endereco.getCep())
                .build();
    }
}
