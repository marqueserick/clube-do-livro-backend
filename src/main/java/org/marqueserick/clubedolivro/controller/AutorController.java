package org.marqueserick.clubedolivro.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.marqueserick.clubedolivro.dto.autor.AutorDto;
import org.marqueserick.clubedolivro.dto.autor.AutorDtoEditar;
import org.marqueserick.clubedolivro.dto.autor.AutorDtoSalvar;
import org.marqueserick.clubedolivro.service.AutorService;

import javax.ws.rs.*;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("autores")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class AutorController {

    private AutorService service;

    public AutorController(AutorService autorService){
        this.service = autorService;
    }

    @GET
    @Operation(description = "lista todos os autores",summary = "listar autores")
    public List<AutorDto> listarAutores(){
        return service.listarAutores();
    }

    @GET
    @Path("/{id}")
    @Operation(description = "lista autor por id",summary = "listar autor")
    public AutorDto listarAutor(@PathParam("id") Long id){
        return service.listarAutor(id);
    }

    @POST
    @Operation(description = "adiciona um novo autor", summary = "adicionar autor")
    public AutorDto adicionarAutor(AutorDtoSalvar dto){
        return service.adicionarAutor(dto);
    }

    @PUT
    @Operation(description = "edita um autor",summary = "editar autor")
    public AutorDto editarAutor(AutorDtoEditar dto){
        return service.editarAutor(dto);
    }

    @DELETE
    @Path("/{id}")
    @Operation(description = "deleta um autor existente", summary = "deletar autor")
    public void deletarAutor(@PathParam("id") Long id){
        service.deletarAutor(id);
    }
}
