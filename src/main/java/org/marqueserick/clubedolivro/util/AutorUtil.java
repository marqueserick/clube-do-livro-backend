package org.marqueserick.clubedolivro.util;

import org.marqueserick.clubedolivro.model.Autor;
import org.marqueserick.clubedolivro.repository.AutorRepository;

import javax.ws.rs.NotFoundException;

public class AutorUtil {

    public static Autor getAutor(Long autor) {
        AutorRepository autorRepository = new AutorRepository();
        return autorRepository.findByIdOptional(autor).orElseThrow(NotFoundException::new);
    }
}
