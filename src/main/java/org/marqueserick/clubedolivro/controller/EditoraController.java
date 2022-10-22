package org.marqueserick.clubedolivro.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.marqueserick.clubedolivro.dto.editora.EditoraDto;
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
    public List<EditoraDto> listaEditoras(){
        return service.listaEditoras();
    }

    @GET
    @Path("/{id}")
    @Operation(description = "Lista editora por ID", summary = "listar por ID")
    public EditoraDto listaEditora(@PathParam("id") Long id){
        return service.listaEditora(id);
    }

    @POST
    @Operation(description = "Adiciona uma nova editora ao sistema", summary = "adicionar editora")
    public EditoraDto novaEditora(EditoraDtoSalvar dto){
        return service.novaEditora(dto);
    }
}
