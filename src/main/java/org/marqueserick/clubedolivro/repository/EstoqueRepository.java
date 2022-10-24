package org.marqueserick.clubedolivro.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.marqueserick.clubedolivro.model.Estoque;
import org.marqueserick.clubedolivro.model.EstoqueLivroPk;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EstoqueRepository implements PanacheRepositoryBase<Estoque, EstoqueLivroPk> {
}
