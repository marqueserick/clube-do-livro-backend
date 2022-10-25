package org.marqueserick.clubedolivro.service;

import org.marqueserick.clubedolivro.dto.categoria.CategoriaDto;
import org.marqueserick.clubedolivro.dto.categoria.CategoriaDtoEditar;
import org.marqueserick.clubedolivro.dto.categoria.CategoriaDtoSalvar;
import org.marqueserick.clubedolivro.factory.CategoriaFactory;
import org.marqueserick.clubedolivro.factory.LivroFactory;
import org.marqueserick.clubedolivro.model.Categoria;
import org.marqueserick.clubedolivro.repository.CategoriaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotFoundException;
import java.util.List;

@Transactional
@ApplicationScoped
public class CategoriaService {

    private CategoriaRepository repository;
    private CategoriaFactory factory;

    public CategoriaService(CategoriaRepository categoriaRepository, CategoriaFactory categoriaFactory){
        this.repository = categoriaRepository;
        this.factory = categoriaFactory;
    }

    public List<CategoriaDto> listarCategorias(){
        return factory.toDtoList(repository.listAll());
    }

    public CategoriaDto listarCategoriaPorId(Long id) {
        Categoria categoria = buscarPorId(id);
        return factory.toDtoDetalhes(categoria);
    }

    public CategoriaDto adicionarCategoria(CategoriaDtoSalvar dto) {

        try{
            buscarPorNome(dto.getNome());
        }catch (NotFoundException e){
            Categoria categoria = new Categoria();
            categoria.setNome(dto.getNome());
            repository.persist(categoria);
            return factory.toDto(categoria);
        }
        throw new NotAllowedException("Categoria já existe");
    }

    public CategoriaDto editarCategoria(CategoriaDtoEditar dto) {
        Categoria categoria = buscarPorId(dto.getId());
        try{
            buscarPorNome(dto.getNome());
        }catch (NotFoundException e) {
            categoria.setNome(dto.getNome());
            repository.persist(categoria);
            return factory.toDtoDetalhes(categoria);
        }
        throw new NotAllowedException("Categoria já existe");
    }

    public void deletarCategoria(CategoriaDto dto) {
        Categoria categoria = buscarPorId(dto.getId());
        repository.delete(categoria);
    }

    private Categoria buscarPorNome(String nomeCategoria) {
        Categoria categoria = repository.find("nome_categoria",nomeCategoria).firstResult();
        if(categoria == null) throw new NotFoundException();
        return categoria;
    }

    private Categoria buscarPorId(Long id) {
        Categoria categoria = repository.findById(id);
        if(categoria == null) throw new NotFoundException();
        return categoria;
    }
}
