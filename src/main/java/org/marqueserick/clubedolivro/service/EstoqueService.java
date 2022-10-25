package org.marqueserick.clubedolivro.service;


import io.quarkus.hibernate.orm.panache.PanacheQuery;
import org.marqueserick.clubedolivro.dto.estoque.EstoqueDto;
import org.marqueserick.clubedolivro.factory.EstoqueFactory;
import org.marqueserick.clubedolivro.model.Estoque;
import org.marqueserick.clubedolivro.model.EstoqueLivroPk;
import org.marqueserick.clubedolivro.repository.EstoqueRepository;
import org.marqueserick.clubedolivro.util.Acao;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.marqueserick.clubedolivro.util.validador.EditoraValidador.existeEditora;
import static org.marqueserick.clubedolivro.util.validador.LivroValidador.existeLivro;

@Transactional
@ApplicationScoped
public class EstoqueService {

    private EstoqueRepository repository;
    private EstoqueFactory factory;

    public EstoqueService(EstoqueRepository estoqueRepository, EstoqueFactory estoqueFactory){
        this.repository = estoqueRepository;
        this.factory = estoqueFactory;
    }

    public List<EstoqueDto> listarEstoque(){
        return factory.toDtoList(repository.listAll());
    }

    public List<EstoqueDto> listarEstoquePorEditora(Long editora) {
       PanacheQuery<Estoque> estoquePorEditora = repository.find("cod_editora",editora);
       List<Estoque> listaEstoquePorEditora = estoquePorEditora.stream().collect(Collectors.toList());
       if(listaEstoquePorEditora.size() == 0) throw new NotFoundException();
       return factory.toDtoList(listaEstoquePorEditora);
    }

    public EstoqueDto listarEstoquePorLivro(Long livro) {
        return factory.toDto(buscarPorLivro(livro));
    }

    public EstoqueDto editarEstoque(EstoqueDto dto) {
        deletarEstoque(dto);
        return adicionarEstoque(dto);
    }

    public EstoqueDto alterarQuantidadeLivro(Long livro, Acao acao, Integer quantidade) {
        Estoque livroSelecionado = buscarPorLivro(livro);
        livroSelecionado.setQuantidade(atualizarQuantidade(acao,quantidade, livroSelecionado.getQuantidade()));
        repository.persist(livroSelecionado);
        return factory.toDto(livroSelecionado);
    }

    public EstoqueDto adicionarEstoque(EstoqueDto dto) {
        try{
            buscarPorLivro(dto.getLivro());
        }catch (NotFoundException e){
             validarPkComposta(dto);
             Estoque novoEstoque = factory.toEstoque(dto);
             repository.persist(novoEstoque);
             return factory.toDto(novoEstoque);
        }
        throw new NotAllowedException("Livro já existe em estoque");
    }

    public void deletarEstoque(EstoqueDto dto){
        Estoque livroSelecionado = buscarPorLivro(dto.getLivro());
        repository.delete(livroSelecionado);
    }

    private Integer atualizarQuantidade(Acao acao, Integer quantidade, Integer quantidadeAtual) {
        switch (acao){
            case ADICIONAR: return quantidadeAtual + quantidade;
            case SUBTRAIR: if(quantidade > quantidadeAtual) return 0;
                return quantidadeAtual - quantidade;
            default: return 0;
        }
    }

    private Estoque buscarPorLivro(Long livro) {
        Optional<Estoque> livroSelecionado =  repository.find("cod_livro", livro).firstResultOptional();
        if(livroSelecionado.isPresent()) return livroSelecionado.get();
        throw new NotFoundException();
    }

    private void validarPkComposta(EstoqueDto dto){
        existeLivro(dto.getLivro());
        existeEditora(dto.getEditora());
    }
}
