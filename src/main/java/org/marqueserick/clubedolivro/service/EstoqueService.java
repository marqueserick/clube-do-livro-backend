package org.marqueserick.clubedolivro.service;


import io.quarkus.hibernate.orm.panache.PanacheQuery;
import org.marqueserick.clubedolivro.dto.estoque.EstoqueDto;
import org.marqueserick.clubedolivro.factory.EstoqueFactory;
import org.marqueserick.clubedolivro.model.Estoque;
import org.marqueserick.clubedolivro.repository.EstoqueRepository;
import org.marqueserick.clubedolivro.util.Acao;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<EstoqueDto> listarEstoqueBusca(String campo, Long editora) {
       PanacheQuery<Estoque> estoquePorEditora = repository.find(campo,editora);
       return factory.toDtoList(estoquePorEditora.stream().collect(Collectors.toList()));
    }

    public EstoqueDto alterarQuantidadeLivro(Long livro, Acao acao, Integer quantidade) {
        Estoque livroSelecionado = buscarPorLivro(livro);
        if( livroSelecionado == null) throw new NotFoundException();

        livroSelecionado.setQuantidade(atualizarQuantidade(acao,quantidade, livroSelecionado.getQuantidade()));
        repository.persist(livroSelecionado);
        return factory.toDto(livroSelecionado);
    }

    public EstoqueDto adicionarLivroEstoque(EstoqueDto dto) {
        boolean existeLivroEmEstoque = buscarPorLivro(dto.getLivro()) != null;
        if(!existeLivroEmEstoque){
             existeLivro(dto.getLivro());
             Estoque novoEstoque = factory.toEstoque(dto);
             repository.persist(novoEstoque);
             return factory.toDto(novoEstoque);
        }
        throw new NotAllowedException("Livro já existe em estoque");
    }

    private Integer atualizarQuantidade(Acao acao, Integer quantidade, Integer quantidadeAtual) {
        switch (acao){
            case CORRIGIR: return quantidade;
            case ADICIONAR: return quantidadeAtual + quantidade;
            case SUBTRAIR: if(quantidade > quantidadeAtual) return 0;
                return quantidadeAtual - quantidade;
            default: return 0;
        }
    }

    private Estoque buscarPorLivro(Long livro) {
        Optional<Estoque> livroSelecionado =  repository.find("cod_livro", livro).firstResultOptional();
        if(livroSelecionado.isPresent()) return livroSelecionado.get();
        else return null;
    }


}
