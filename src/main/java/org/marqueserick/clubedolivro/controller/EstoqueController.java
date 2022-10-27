package org.marqueserick.clubedolivro.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.marqueserick.clubedolivro.dto.estoque.EstoqueDto;
import org.marqueserick.clubedolivro.service.EstoqueService;
import org.marqueserick.clubedolivro.enums.Acao;

import javax.ws.rs.*;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("estoque")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class EstoqueController {

    private EstoqueService service;

    public EstoqueController(EstoqueService estoqueService){
        this.service = estoqueService;
    }

    @GET
    @Operation(description = "lista todos os valores do estoque", summary = "listar estoque")
    public List<EstoqueDto> listarEstoque(){
        return service.listarEstoque();
    }

    @GET
    @Path("/porEditora")
    @Operation(description = "lista quantidade de todos os livros por editora", summary = "listar por editora")
    public List<EstoqueDto> listarEstoquePorEditora(@QueryParam("cod")Long editora){
        return service.listarEstoquePorEditora(editora);
    }

    @GET
    @Path("/porLivro")
    @Operation(description = "lista quantidade por livro", summary = "listar por livro")
    public EstoqueDto listarEstoquePorLivro(@QueryParam("cod")Long livro){
        return service.listarEstoquePorLivro(livro);
    }

    @POST
    @Operation(description = "adiciona um livro ao estoque", summary = "adicionar livro ao estoque")
    public EstoqueDto adicionarEstoque(EstoqueDto dto){
        return service.adicionarEstoque(dto);
    }

    @PUT
    @Operation(description = "edita informações de livro em estoque", summary = "editar livro em estoque")
    public EstoqueDto editarEstoque(EstoqueDto dto){
        return service.editarEstoque(dto);
    }

    @PUT
    @Path("/porLivro")
    @Operation(description = "altera quantidade de livro em estoque", summary = "alterar quantidade livro")
    public EstoqueDto alterarQuantidadeLivro(@QueryParam("cod")Long livro, @QueryParam("acao") Acao acao, @QueryParam("quantidade")Integer quantidade){
        return service.alterarQuantidadeLivro(livro, acao, quantidade);
    }

    @DELETE
    @Path("/{cod_livro}")
    @Operation(description = "deleta um livro do estoque", summary = "deletar do estoque")
    public void deletarEstoque(@PathParam("cod_livro")Long id){
        service.deletarEstoque(id);
    }
}
