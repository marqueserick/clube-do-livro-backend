package org.marqueserick.clubedolivro.configuration.swagger;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        tags = {
                @Tag(name = "Livro Controller", description = "Requisições para livros"),
                @Tag(name = "Editora Controller", description = "Requisiçoes para editoras"),
                @Tag(name = "Estoque Controller", description = "Requisições para estoque"),
                @Tag(name = "Categoria Controller", description = "Requisições para categorias"),
                @Tag(name = "Categoria Livro Controller", description = "Requisições para categoriaLivro"),
                @Tag(name = "Autor Controller", description = "Requisições para autores")
},
        info = @Info(
                title="Clube do Livro",
                version = "1.0.0",
                contact = @Contact(
                        name = "Erick Marques",
                        url = "http://linkedin.com/in/marqueserick",
                        email = "erickmarques43@gmail.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html")))
public class SwaggerConfiguration extends Application {
}
