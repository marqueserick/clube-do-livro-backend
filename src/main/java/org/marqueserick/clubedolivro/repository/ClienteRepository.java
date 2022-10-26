package org.marqueserick.clubedolivro.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.marqueserick.clubedolivro.model.Cliente;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteRepository implements PanacheRepositoryBase<Cliente, Long> {
}
