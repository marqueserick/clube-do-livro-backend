package org.marqueserick.clubedolivro.util;

import org.marqueserick.clubedolivro.model.Livro;
import org.marqueserick.clubedolivro.repository.LivroRepository;

import javax.ws.rs.NotFoundException;

public class LivroUtil {

    public static Livro getLivro(Long livro) {
        LivroRepository livroRepository = new LivroRepository();
        return livroRepository.findByIdOptional(livro).orElseThrow(NotFoundException::new);
    }
}
