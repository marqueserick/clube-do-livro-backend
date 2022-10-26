package org.marqueserick.clubedolivro.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.marqueserick.clubedolivro.dto.autorLivro.AutorLivroDto;
import org.marqueserick.clubedolivro.dto.autorLivro.AutorLivroDtoResposta;
import org.marqueserick.clubedolivro.service.AutorLivroService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("livros")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class AutorLivroController {

    private AutorLivroService service;

    public AutorLivroController(AutorLivroService service){
        this.service = service;
    }

    @POST
    @Path("/autor")
    @Operation(description = "adiciona uma nova relação autor-livro", summary = "adicionar relação autor-livro")
    public AutorLivroDtoResposta adicionarAutor(AutorLivroDto dto){
        return service.adicionarAutor(dto);
    }

    @POST
    @Path("/autores")
    @Operation(description = "adiciona uma lista de relações autor-livro", summary = "adicionar lista autor-livro")
    public List<AutorLivroDtoResposta> adicionarAutor(List<AutorLivroDto> dto){
        return service.adicionarAutor(dto);
    }

    @DELETE
    @Path("/autor")
    @Operation(description = "deleta uma relação autor-livro existente", summary = "deletar relação autor-livro")
    public void deletarAutor(AutorLivroDto dto){
        service.deletarAutor(dto);
    }
}
