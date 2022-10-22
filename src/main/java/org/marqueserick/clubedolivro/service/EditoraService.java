package org.marqueserick.clubedolivro.service;

import org.marqueserick.clubedolivro.dto.editora.EditoraDto;
import org.marqueserick.clubedolivro.dto.editora.EditoraDtoSalvar;
import org.marqueserick.clubedolivro.factory.EditoraFactory;
import org.marqueserick.clubedolivro.model.Editora;
import org.marqueserick.clubedolivro.repository.EditoraRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;

@Transactional
@ApplicationScoped
public class EditoraService {

    private EditoraRepository repository;
    private EditoraFactory factory;

    public EditoraService(EditoraRepository editoraRepository, EditoraFactory editoraFactory){
        this.repository = editoraRepository;
        this.factory = editoraFactory;
    }

    public List<EditoraDto> listaEditoras(){
        return factory.toDtoList(repository.listAll());
    }

    public EditoraDto listaEditora(Long id) {
        return factory.toDtoDetalhes(buscarEditoraPorId(id));
    }

    public EditoraDto novaEditora(EditoraDtoSalvar dto) {
        Editora editora = factory.toEditora(dto);
        repository.persist(editora);
        return factory.toDto(editora);
    }

    private Editora buscarEditoraPorId(Long id) {
        Editora editora = repository.findById(id);
        if (editora == null) throw new NotFoundException();
        return editora;
    }
}
