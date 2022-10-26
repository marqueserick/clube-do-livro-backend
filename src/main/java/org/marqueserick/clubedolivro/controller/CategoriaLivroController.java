package org.marqueserick.clubedolivro.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.marqueserick.clubedolivro.dto.categoriaLivro.CategoriaLivroDto;
import org.marqueserick.clubedolivro.dto.categoriaLivro.CategoriaLivroDtoResposta;
import org.marqueserick.clubedolivro.service.CategoriaLivroService;

import javax.ws.rs.*;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("livros")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class CategoriaLivroController {

    private CategoriaLivroService service;

    public CategoriaLivroController(CategoriaLivroService categoriaLivroService){
        this.service = categoriaLivroService;
    }

    @POST
    @Path("/categoria")
    @Operation(description = "adiciona uma nova relação categoria-livro", summary = "adicionar relação categoria-livro")
    public CategoriaLivroDtoResposta adicionarCategoria(CategoriaLivroDto dto){
        return service.adicionarCategoria(dto);
    }

    @POST
    @Path("/categorias")
    @Operation(description = "adiciona uma lista de relações categoria-livro", summary = "adicionar lista categoria-livro")
    public List<CategoriaLivroDtoResposta> adicionarCategoria(List<CategoriaLivroDto> dto){
        return service.adicionarCategoria(dto);
    }

    @DELETE
    @Path("/categoria")
    @Operation(description = "deleta uma relação categoria-livro existente", summary = "deletar relação categoria-livro")
    public void deletarCategoria(CategoriaLivroDto dto){
        service.deletarCategoria(dto);
    }
}
