package org.marqueserick.clubedolivro.util.validador;

import org.marqueserick.clubedolivro.factory.LivroFactory;
import org.marqueserick.clubedolivro.repository.LivroRepository;
import org.marqueserick.clubedolivro.service.LivroService;

public class LivroValidador {

    public static void existeLivro(Long id){
        LivroService service = new LivroService(new LivroRepository(), new LivroFactory());
        service.listarLivro(id);
    }
}
