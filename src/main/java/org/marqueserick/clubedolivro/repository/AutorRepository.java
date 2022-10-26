package org.marqueserick.clubedolivro.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.marqueserick.clubedolivro.model.Autor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AutorRepository implements PanacheRepositoryBase<Autor, Long> {
}
