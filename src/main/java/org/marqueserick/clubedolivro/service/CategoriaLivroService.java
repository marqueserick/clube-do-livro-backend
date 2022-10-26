package org.marqueserick.clubedolivro.service;

import org.marqueserick.clubedolivro.dto.categoriaLivro.CategoriaLivroDto;
import org.marqueserick.clubedolivro.dto.categoriaLivro.CategoriaLivroDtoResposta;
import org.marqueserick.clubedolivro.factory.CategoriaLivroFactory;
import org.marqueserick.clubedolivro.model.Categoria;
import org.marqueserick.clubedolivro.model.CategoriaLivro;
import org.marqueserick.clubedolivro.model.Livro;
import org.marqueserick.clubedolivro.repository.CategoriaLivroRepository;
import org.marqueserick.clubedolivro.repository.CategoriaRepository;
import org.marqueserick.clubedolivro.repository.LivroRepository;
import org.marqueserick.clubedolivro.util.CategoriaUtil;
import org.marqueserick.clubedolivro.util.LivroUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@ApplicationScoped
public class CategoriaLivroService {

    private CategoriaLivroRepository repository;
    private CategoriaLivroFactory factory;

    public CategoriaLivroService(CategoriaLivroRepository repository, CategoriaLivroFactory factory){
        this.repository = repository;
        this.factory = factory;
    }

    public CategoriaLivroDtoResposta adicionarCategoria(CategoriaLivroDto dto) {
        if (repository.findCategoriaLivro(dto) == null){
            Livro livro = LivroUtil.getLivro(dto.getLivro());
            Categoria categoria = CategoriaUtil.getCategoria(dto.getCategoria());

            return factory.toDto(repository.adicionar(livro,categoria));
        }

        throw new NotAllowedException("Categoria e livro já estão relacionados");
    }

    public List<CategoriaLivroDtoResposta> adicionarCategoria(List<CategoriaLivroDto> dto){
        List<CategoriaLivroDtoResposta> dtoList = new ArrayList<>();

        for( CategoriaLivroDto d : dto){
            try{
                dtoList.add(adicionarCategoria(d));
            }catch (Exception e){
                break;
            }
        }

        return dtoList;
    }

    public void deletarCategoria(CategoriaLivroDto dto) {
        CategoriaLivro categoriaLivro = repository.findCategoriaLivro(dto);
        if (categoriaLivro == null) throw new NotFoundException();

        repository.delete(categoriaLivro);

    }
}
