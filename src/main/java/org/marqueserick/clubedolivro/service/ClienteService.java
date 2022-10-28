package org.marqueserick.clubedolivro.service;

import org.marqueserick.clubedolivro.dto.cliente.ClienteDto;
import org.marqueserick.clubedolivro.dto.cliente.ClientePessoaFisicaDto;
import org.marqueserick.clubedolivro.dto.cliente.ClientePessoaJuridicaDto;
import org.marqueserick.clubedolivro.factory.ClienteFactory;
import org.marqueserick.clubedolivro.model.Cliente;
import org.marqueserick.clubedolivro.repository.ClienteRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;

@Transactional
@ApplicationScoped
public class ClienteService {

    private ClienteRepository repository;
    private ClienteFactory factory;

    public ClienteService(ClienteRepository clienteRepository, ClienteFactory clienteFactory){
        this.repository = clienteRepository;
        this.factory = clienteFactory;
    }

    public List<ClienteDto> listarClientes(){
        return factory.toDtoList(repository.listAll());
    }

    public ClienteDto listarCliente(Long id){
        Cliente cliente = buscarPorId(id);
        return factory.toDtoDetalhes(cliente);
    }

    public ClienteDto editarCliente(ClienteDto dto) {
        Cliente cliente = buscarPorId(dto.getId());

        repository.persist(cliente);
        return factory.toDtoDetalhes(cliente);
    }

    public ClienteDto adicionarCliente(ClientePessoaFisicaDto dto) {
        Cliente cliente = novoCliente(dto);
        repository.persist(cliente);
        return factory.toDto(cliente);
    }

    public ClienteDto adicionarCliente(ClientePessoaJuridicaDto dto) {
        Cliente cliente = novoCliente(dto);
        repository.persist(cliente);
        return factory.toDto(cliente);
    }

    private Cliente buscarPorId(Long id) {
        Cliente cliente = repository.findById(id);
        if(cliente == null) throw new NotFoundException();
        return cliente;
    }

    private Cliente novoCliente(ClientePessoaFisicaDto dto) {
        Cliente cliente = factory.toCliente(dto);
        cliente.getEndereco().setCliente(cliente);
        cliente.getPessoa().setCliente(cliente);
        return cliente;
    }

    private Cliente novoCliente(ClientePessoaJuridicaDto dto) {
        Cliente cliente = factory.toCliente(dto);
        cliente.getEndereco().setCliente(cliente);
        cliente.getPessoa().setCliente(cliente);
        return cliente;
    }
}
