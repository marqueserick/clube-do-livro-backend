package org.marqueserick.clubedolivro.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.marqueserick.clubedolivro.dto.categoria.CategoriaDto;
import org.marqueserick.clubedolivro.dto.categoria.CategoriaDtoEditar;
import org.marqueserick.clubedolivro.dto.categoria.CategoriaDtoSalvar;
import org.marqueserick.clubedolivro.dto.livro.LivroDto;
import org.marqueserick.clubedolivro.dto.livro.LivroDtoEditar;
import org.marqueserick.clubedolivro.service.CategoriaService;

import javax.ws.rs.*;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("categorias")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class CategoriaController {

    private CategoriaService service;

    public CategoriaController(CategoriaService categoriaService){
        this.service = categoriaService;
    }

    @GET
    @Operation(description = "lista todas as categorias", summary = "listar categorias")
    public List<CategoriaDto> listarCategorias(){
        return service.listarCategorias();
    }

    @GET
    @Path("/{id}")
    @Operation(description = "lista categoria por id", summary = "listar por id")
    public CategoriaDto listarCategoriaPorId(@PathParam("id")Long id){
        return service.listarCategoriaPorId(id);
    }

    @POST
    @Operation(description = "adiciona uma categoria",summary = "adicionar categoria")
    public CategoriaDto adicionarCategoria(CategoriaDtoSalvar dto){
        return service.adicionarCategoria(dto);
    }

    @PUT
    @Operation(description = "edita uma categoria", summary = "editar categoria")
    public CategoriaDto editarCategoria(CategoriaDtoEditar dto){
        return service.editarCategoria(dto);
    }

    @DELETE
    @Operation(description = "deleta uma categoria", summary = "deletar categoria")
    public void deletarCategoria(CategoriaDto dto){
        service.deletarCategoria(dto);
    }

}
