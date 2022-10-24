package org.marqueserick.clubedolivro.service;

import org.marqueserick.clubedolivro.dto.editora.EditoraDto;
import org.marqueserick.clubedolivro.dto.editora.EditoraDtoEditar;
import org.marqueserick.clubedolivro.dto.editora.EditoraDtoSalvar;
import org.marqueserick.clubedolivro.factory.EditoraFactory;
import org.marqueserick.clubedolivro.model.Editora;
import org.marqueserick.clubedolivro.repository.EditoraRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotAllowedException;
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

    public EditoraDto adicionarEditora(EditoraDtoSalvar dto) {
        Editora editora = factory.toEditora(dto);
        repository.persist(editora);
        return factory.toDto(editora);
    }

    public EditoraDto editarEditora(EditoraDtoEditar dto) {
        Editora editoraEditada = buscarEditoraPorId(dto.getId());
        editarEditora(editoraEditada,dto);
        repository.persist(editoraEditada);
        return factory.toDto(editoraEditada);
    }

    public void deletarEditora(Long id) {
        Editora excluirEditora = buscarEditoraPorId(id);
        if(excluirEditora.getLivros().size()>0){
            throw new NotAllowedException("Não é permitido excluir editora com livros cadastrados no sistema");
        }
        repository.delete(excluirEditora);
    }

    private void editarEditora(Editora editora, EditoraDtoEditar dto) {
        editora.setNome(dto.getNome());
        editora.setTelefoneAuxiliar(dto.getTelefoneAuxiliar());
        editora.setTelefonePrincipal(dto.getTelefonePrincipal());
        editora.setEmail(dto.getEmail());
        editora.setNomeContato(dto.getNomeContato());
    }

    private Editora buscarEditoraPorId(Long id) {
        Editora editora = repository.findById(id);
        if (editora == null) throw new NotFoundException();
        return editora;
    }
}
