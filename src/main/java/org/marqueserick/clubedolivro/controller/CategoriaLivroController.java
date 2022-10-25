package org.marqueserick.clubedolivro.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.marqueserick.clubedolivro.dto.categoria.CategoriaLivroDto;
import org.marqueserick.clubedolivro.dto.categoria.CategoriaLivroDtoDetalhes;
import org.marqueserick.clubedolivro.service.CategoriaLivroService;

import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("cl")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class CategoriaLivroController {

    private CategoriaLivroService service;

    public CategoriaLivroController(CategoriaLivroService categoriaLivroService){
        this.service = categoriaLivroService;
    }

    @POST
    @Path("/livros/categorias")
    @Operation(description = "adiciona lista de categorias à um livro", summary = "adicionar categorias")
    public CategoriaLivroDtoDetalhes adicionarCategorias(CategoriaLivroDto dto){
        return service.adicionarCategoria(dto);
    }
}
