package org.marqueserick.clubedolivro.factory;

import org.marqueserick.clubedolivro.dto.cliente.ClienteDto;
import org.marqueserick.clubedolivro.dto.cliente.ClienteDtoSalvar;
import org.marqueserick.clubedolivro.model.Cliente;
import org.marqueserick.clubedolivro.model.PessoaJuridica;

import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class ClienteFactory {

    public ClienteDto toDto(Cliente cliente){
        return ClienteDto.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .telefonePrincipal(cliente.getTelefonePrincipal())
                .telefoneAuxiliar(cliente.getTelefoneAuxiliar())
                .email(cliente.getEmail())
                .build();
    }

    public ClienteDto toDtoDetalhes(Cliente cliente){
        return ClienteDto.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .telefonePrincipal(cliente.getTelefonePrincipal())
                .telefoneAuxiliar(cliente.getTelefoneAuxiliar())
                .email(cliente.getEmail())
                .endereco(new EnderecoFactory().toDto(cliente.getEndereco()))
                .build();
    }
    public Cliente toCliente(ClienteDtoSalvar dto) {
        return Cliente.builder()
                .nome(dto.getNome())
                .telefonePrincipal(dto.getTelefonePrincipal())
                .telefoneAuxiliar(dto.getTelefoneAuxiliar())
                .email(dto.getEmail())
                .endereco(new EnderecoFactory().toEndereco(dto.getEnderecoDto()))
                .build();
    }

    public Cliente toClientePessoaFisica(ClienteDtoSalvar dto) {
        return Cliente.builder()
                .nome(dto.getNome())
                .telefonePrincipal(dto.getTelefonePrincipal())
                .telefoneAuxiliar(dto.getTelefoneAuxiliar())
                .email(dto.getEmail())
                .endereco(new EnderecoFactory().toEndereco(dto.getEnderecoDto()))
                .build();
    }

    public Cliente toClientePessoaJuridica(ClienteDtoSalvar dto) {
        return Cliente.builder()
                .nome(dto.getNome())
                .telefonePrincipal(dto.getTelefonePrincipal())
                .telefoneAuxiliar(dto.getTelefoneAuxiliar())
                .email(dto.getEmail())
                .endereco(new EnderecoFactory().toEndereco(dto.getEnderecoDto()))
                .build();
    }

    public List<ClienteDto> toDtoList(List<Cliente> clientes) {
        return clientes.stream().map(this::toDto).collect(Collectors.toList());
    }

}
