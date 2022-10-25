package org.marqueserick.clubedolivro.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.marqueserick.clubedolivro.model.Categoria;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoriaRepository implements PanacheRepositoryBase<Categoria, Long> {
}
