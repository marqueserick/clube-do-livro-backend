package org.marqueserick.clubedolivro.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.marqueserick.clubedolivro.dto.editora.EditoraDto;
import org.marqueserick.clubedolivro.dto.editora.EditoraDtoEditar;
import org.marqueserick.clubedolivro.dto.editora.EditoraDtoSalvar;
import org.marqueserick.clubedolivro.service.EditoraService;

import javax.ws.rs.*;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("editoras")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class EditoraController {

    private EditoraService service;

    public EditoraController(EditoraService editoraService){
        this.service = editoraService;
    }

    @GET
    @Operation(description = "Lista todas as editoras cadastradas no sistema", summary = "listar editoras")
    public List<EditoraDto> listarEditoras(){
        return service.listaEditoras();
    }

    @GET
    @Path("/{id}")
    @Operation(description = "Lista editora por ID", summary = "listar por ID")
    public EditoraDto listarEditora(@PathParam("id") Long id){
        return service.listaEditora(id);
    }

    @POST
    @Operation(description = "Adiciona uma nova editora ao sistema", summary = "adicionar editora")
    public EditoraDto adicionarEditora(EditoraDtoSalvar dto){
        return service.adicionarEditora(dto);
    }

    @PUT
    @Operation(description = "Edita uma editora existente", summary = "editar editora")
    public EditoraDto editarEditora(EditoraDtoEditar dto){
        return service.editarEditora(dto);
    }

    @DELETE
    @Path("/{id}")
    @Operation(description = "Deleta um editora existente", summary = "deletar editora")
    public void deletarEditora(@PathParam("id") Long id){
        service.deletarEditora(id);
    }
}
