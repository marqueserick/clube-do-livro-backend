package org.marqueserick.clubedolivro.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.marqueserick.clubedolivro.model.Livro;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LivroRepository implements PanacheRepositoryBase<Livro, Long> {
}
