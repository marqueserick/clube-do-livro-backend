package org.marqueserick.clubedolivro.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.marqueserick.clubedolivro.model.Livro;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class LivroRepository implements PanacheRepositoryBase<Livro, Long> {
    public List<Livro> livrosSemCadastroEstoque(){
        return this.list("from Livro where id not in(select id.livro from Estoque)");
    }

    public List<Livro> livrosEstoqueZerado(){
        return this.list("select l from Livro l left join Estoque e on l.id = e.id.livro where e.quantidade = 0");
    }
}
