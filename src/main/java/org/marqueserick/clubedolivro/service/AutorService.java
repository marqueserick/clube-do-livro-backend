package org.marqueserick.clubedolivro.service;

import org.marqueserick.clubedolivro.dto.autor.AutorDto;
import org.marqueserick.clubedolivro.dto.autor.AutorDtoEditar;
import org.marqueserick.clubedolivro.dto.autor.AutorDtoSalvar;
import org.marqueserick.clubedolivro.factory.AutorFactory;
import org.marqueserick.clubedolivro.model.Autor;
import org.marqueserick.clubedolivro.repository.AutorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotFoundException;
import java.util.List;

@Transactional
@ApplicationScoped
public class AutorService {

    private AutorRepository repository;
    private AutorFactory factory;

    public AutorService(AutorRepository autorRepository, AutorFactory autorFactory){
        this.repository = autorRepository;
        this.factory = autorFactory;
    }

    public List<AutorDto> listarAutores() {
        return factory.toDtoList(repository.listAll());
    }

    public AutorDto listarAutor(Long id){
        return factory.toDtoDetalhes(buscarPorId(id));
    }

    public AutorDto adicionarAutor(AutorDtoSalvar dto) {
        Autor autor = Autor.builder().nome(dto.getNome()).build();
        repository.persist(autor);
        return factory.toDto(autor);
    }

    public AutorDto editarAutor(AutorDtoEditar dto) {
        Autor autor = buscarPorId(dto.getId());
        autor.setNome(dto.getNome());
        repository.persist(autor);
        return factory.toDto(autor);
    }

    public void deletarAutor(Long id) {
        Autor autor = buscarPorId(id);
        if(autor.getLivros().size()>0){
            throw new NotAllowedException("Não é possível excluir autor com livros publicados");
        }

        repository.delete(autor);
    }

    private Autor buscarPorId(Long id) {
        Autor autor = repository.findById(id);
        if(autor == null) throw new NotFoundException();
        return autor;
    }



}
