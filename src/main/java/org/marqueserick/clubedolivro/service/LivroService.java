package org.marqueserick.clubedolivro.service;

import org.marqueserick.clubedolivro.dto.livro.LivroDto;
import org.marqueserick.clubedolivro.dto.livro.LivroDtoEditar;
import org.marqueserick.clubedolivro.dto.livro.LivroDtoSalvar;
import org.marqueserick.clubedolivro.factory.EditoraFactory;
import org.marqueserick.clubedolivro.factory.LivroFactory;
import org.marqueserick.clubedolivro.model.Editora;
import org.marqueserick.clubedolivro.model.Livro;
import org.marqueserick.clubedolivro.repository.EditoraRepository;
import org.marqueserick.clubedolivro.repository.LivroRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;

@Transactional
@ApplicationScoped
public class LivroService {

    private LivroRepository repository;
    private LivroFactory factory;

    private EditoraService editoraService;

    public LivroService(LivroRepository livroRepository, LivroFactory livroFactory, EditoraService editoraService){
        this.repository = livroRepository;
        this.factory = livroFactory;
        this.editoraService = editoraService;
    }

    public List<LivroDto> listarLivros(){
        return factory.toDtoList(repository.listAll());
    }

    public LivroDto listarLivro(Long id) {
            return factory.toDtoDetalhes(buscarLivroPorId(id));
    }

    public LivroDto novoLivro(LivroDtoSalvar dto) {
        Livro salvarLivro = factory.toLivro(dto);
        repository.persist(salvarLivro);
        return factory.toDto(salvarLivro);

    }

    public LivroDto editarLivro(LivroDtoEditar dto) {
        Livro editarLivro = buscarLivroPorId(dto.getId());
        editarLivro(editarLivro, dto);
        repository.persist(editarLivro);
        return factory.toDto(editarLivro);
    }

    public void deletarLivro(LivroDto dto) {
        Livro excluirLivro = buscarLivroPorId(dto.getId());
        repository.delete(excluirLivro);
    }

    private Livro buscarLivroPorId(Long id) {
        Livro livro = repository.findById(id);
        if(livro == null) throw new NotFoundException();
        return livro;
    }
    private void editarLivro(Livro livro, LivroDtoEditar dto){
        livro.setNome(dto.getNome());
        livro.setPreco(dto.getPreco());
        livro.setAnoPublicacao(dto.getAnoPublicacao());
        livro.setIsbn(dto.getIsbn());
        livro.setEditora(new EditoraFactory().toEditora(dto.getEditora()));
    }
}
