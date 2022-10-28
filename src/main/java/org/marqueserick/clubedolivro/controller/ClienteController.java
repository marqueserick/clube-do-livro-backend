package org.marqueserick.clubedolivro.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.marqueserick.clubedolivro.dto.cliente.ClienteDto;
import org.marqueserick.clubedolivro.dto.cliente.ClientePessoaFisicaDto;
import org.marqueserick.clubedolivro.dto.cliente.ClientePessoaJuridicaDto;
import org.marqueserick.clubedolivro.service.ClienteService;

import javax.ws.rs.*;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("clientes")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ClienteController {

    private ClienteService service;

    public ClienteController(ClienteService clienteService){
        this.service = clienteService;
    }

    @GET
    @Operation(description = "lista todos os clientes",summary = "listar clientes")
    public List<ClienteDto> listarClientes(){
        return service.listarClientes();
    }

    @GET
    @Path("/{id}")
    @Operation(description = "lista cliente por Id",summary = "listar por Id")
    public ClienteDto listarCliente(@PathParam("id") Long id){
        return service.listarCliente(id);
    }

    @PUT
    @Operation(description = "edita um cliente existente", summary = "editar cliente")
    public ClienteDto editarCliente(ClienteDto dto){
        return service.editarCliente(dto);
    }

    @POST
    @Path("/pf")
    @Operation(description = "adiciona um novo cliente do tipo Pessoa Física", summary = "adicionar cliente")
    public ClienteDto adicionarCliente(ClientePessoaFisicaDto dto){
        return service.adicionarCliente(dto);
    }

    @POST
    @Path("/pj")
    @Operation(description = "adiciona um novo cliente do tipo Pessoa Jurídica", summary = "adicionar cliente")
    public ClienteDto adicionarCliente(ClientePessoaJuridicaDto dto){
        return service.adicionarCliente(dto);
    }
}
