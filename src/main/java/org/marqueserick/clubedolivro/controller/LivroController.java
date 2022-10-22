package org.marqueserick.clubedolivro.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.marqueserick.clubedolivro.dto.livro.LivroDto;
import org.marqueserick.clubedolivro.dto.livro.LivroDtoEditar;
import org.marqueserick.clubedolivro.dto.livro.LivroDtoSalvar;
import org.marqueserick.clubedolivro.service.LivroService;

import javax.ws.rs.*;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("livros")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class LivroController {

    private LivroService service;

    public LivroController(LivroService livroService){
        this.service = livroService;
    }

    @GET
    @Operation(description = "Lista todos os livros, disponíveis ou indisponíveis, do sistema", summary = "listar livros")
    public List<LivroDto> listarLivros(){
        return service.listarLivros();
    }

    @GET
    @Path("{id}")
    @Operation(description = "Lista livro por ID", summary = "listar por ID")
    public LivroDto listarLivro(@PathParam("id")Long id){
        return service.listarLivro(id);
    }

    @POST
    @Operation(description = "Adiciona um novo livro no sistema", summary = "adicionar livro")
    public LivroDto novoLivro(LivroDtoSalvar dto){
        return service.novoLivro(dto);
    }

    @PUT
    @Operation(description = "Edita um livro existente", summary = "editar livro")
    public LivroDto editarLivro(LivroDtoEditar dto){
        return service.editarLivro(dto);
    }

    @DELETE
    @Path("/{id}")
    @Operation(description = "Exclui um livro existente", summary = "deletar livro")
    public void deletarLivro(@PathParam("id") Long id){
        service.deletarLivro(id);
    }

}
