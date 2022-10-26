--inserir editoras
insert into editora values (1,'contato@primeiraeditora.com.br','Primeira Editora','Maria da Graca',null,'11999891010'),
(2,'externo@melhoreditora.com','Melhor Editora','Luciana','1155778899','11987654321');

--inserir livros
insert into livro values (1,2020,'999888777765','O primeiro livro do mundo',19.99,1),
(2,2018,'999888777766','O segredo',24.5,1),
(3,2019,'999888777755','Dicas de Inglês',39,2),
(4,2016, '83674836942634','Jogos Vorazes',39.9,2);

--inserir autores
insert into autor values (1,'Roberval Lírio'),(2,'Aretha Coautora'),(3,'Frank Sorriso'),(4,'Expert no Assunto'),(5, 'Professora Renata Silva');

insert into estoque values (1,1,13), (1,2,5);

insert into categoria values (1, 'Romance'), (2,'Autoajuda'),(3,'Fantasia'), (4,'Ficção'),(5,'Não Ficção'), (6,'Didático'),(7,'Jovem Adulto');

insert into categoria_livro values (1,5,1), (2,2,1), (3,2,2), (4,4,2),(5,6,3),(6,5,3), (7,3,4),(8,4,4), (9,7,4);

insert into autor_livro values (1,3,1),(2,1,2), (3,2,2),(4,5,3),(5,3,4);

