package org.marqueserick.clubedolivro.service;

import org.marqueserick.clubedolivro.dto.categoria.CategoriaLivroDto;
import org.marqueserick.clubedolivro.dto.categoria.CategoriaLivroDtoDetalhes;
import org.marqueserick.clubedolivro.factory.CategoriaLivroFactory;
import org.marqueserick.clubedolivro.model.Categoria;
import org.marqueserick.clubedolivro.model.CategoriaLivro;
import org.marqueserick.clubedolivro.model.Livro;
import org.marqueserick.clubedolivro.repository.CategoriaLivroRepository;
import org.marqueserick.clubedolivro.repository.CategoriaRepository;
import org.marqueserick.clubedolivro.repository.LivroRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotAllowedException;

@Transactional
@ApplicationScoped
public class CategoriaLivroService {

    private CategoriaLivroRepository repository;
    private CategoriaLivroFactory factory;

    public CategoriaLivroService(CategoriaLivroRepository repository, CategoriaLivroFactory factory){
        this.repository = repository;
        this.factory = factory;
    }

    public CategoriaLivroDtoDetalhes adicionarCategoria(CategoriaLivroDto dto) {
        CategoriaLivro cl = repository.findCategoriaLivro(dto);
        if (cl == null){
            Livro livro = getLivro(dto.getLivro());
            Categoria categoria = getCategoria(dto.getCategoria());
            CategoriaLivro salvarcl = new CategoriaLivro();
            return factory.toDto(repository.adicionar(livro,categoria));
        }

        throw new NotAllowedException("Categoria e livro já estão relacionados");
    }

    private static Categoria getCategoria(Long categoria) {
        CategoriaRepository categoriaRepository = new CategoriaRepository();
        return categoriaRepository.findById(categoria);
    }

    private static Livro getLivro(Long livro) {
        LivroRepository livroRepository = new LivroRepository();
        return livroRepository.findById(livro);
    }
}
