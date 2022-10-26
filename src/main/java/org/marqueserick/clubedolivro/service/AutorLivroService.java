package org.marqueserick.clubedolivro.service;

import org.marqueserick.clubedolivro.dto.autorLivro.AutorLivroDto;
import org.marqueserick.clubedolivro.dto.autorLivro.AutorLivroDtoResposta;
import org.marqueserick.clubedolivro.factory.AutorLivroFactory;
import org.marqueserick.clubedolivro.model.Autor;
import org.marqueserick.clubedolivro.model.AutorLivro;
import org.marqueserick.clubedolivro.model.Livro;
import org.marqueserick.clubedolivro.repository.AutorLivroRepository;
import org.marqueserick.clubedolivro.util.AutorUtil;
import org.marqueserick.clubedolivro.util.LivroUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@ApplicationScoped
public class AutorLivroService {

    private AutorLivroRepository repository;
    private AutorLivroFactory factory;

    public AutorLivroService(AutorLivroRepository repository, AutorLivroFactory factory){
        this.repository = repository;
        this.factory = factory;
    }
    public AutorLivroDtoResposta adicionarAutor(AutorLivroDto dto) {
        if(repository.findAutorLivro(dto) == null){
            Livro livro = LivroUtil.getLivro(dto.getLivro());
            Autor autor = AutorUtil.getAutor(dto.getAutor());

            return factory.toDto(repository.adicionar(livro, autor));
        }
        throw new NotAllowedException("Autor e Livro já estão relacionados");
    }

    public List<AutorLivroDtoResposta> adicionarAutor(List<AutorLivroDto> dto){
        List<AutorLivroDtoResposta> retorno = new ArrayList<>();
        for(AutorLivroDto d: dto){
            try{
                retorno.add(adicionarAutor(d));
            }catch (Exception e){
                break;
            }
        }
        return retorno;
    }

    public void deletarAutor(AutorLivroDto dto){
        AutorLivro autorLivro = repository.findAutorLivro(dto);
        if(autorLivro == null) throw new NotFoundException();

        repository.delete(autorLivro);
    }
}
