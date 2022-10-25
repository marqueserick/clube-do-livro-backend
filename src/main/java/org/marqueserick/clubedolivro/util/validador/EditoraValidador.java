package org.marqueserick.clubedolivro.util.validador;

import org.marqueserick.clubedolivro.factory.EditoraFactory;
import org.marqueserick.clubedolivro.repository.EditoraRepository;
import org.marqueserick.clubedolivro.service.EditoraService;

public class EditoraValidador {

    public static void existeEditora(Long id){
        EditoraService service = new EditoraService(new EditoraRepository(),new EditoraFactory());
        service.listaEditora(id);
    }
}
