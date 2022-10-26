package org.marqueserick.clubedolivro.util;

import org.marqueserick.clubedolivro.model.Categoria;
import org.marqueserick.clubedolivro.repository.CategoriaRepository;

import javax.ws.rs.NotFoundException;

public class CategoriaUtil {

    public static Categoria getCategoria(Long categoria){
        CategoriaRepository categoriaRepository = new CategoriaRepository();
        return categoriaRepository.findByIdOptional(categoria).orElseThrow(NotFoundException::new);
    }
}
