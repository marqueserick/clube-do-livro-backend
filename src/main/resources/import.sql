--inserir editoras
insert into editora values (1,'contato@primeiraeditora.com.br','Primeira Editora','Maria da Graca',null,'11999891010'),
(2,'externo@melhoreditora.com','Melhor Editora','Luciana','1155778899','11987654321');

--inserir livros
insert into livro values (1,2020,'999888777765','O primeiro livro do mundo',19.99,1),
(2,2018,'999888777766','O segredo',24.5,1),
(3,2019,'999888777755','Dicas de Inglês',39,2),
(4,2016, '83674836942634','Jogos Vorazes',39.9,2);

--inserir autores
insert into autor values (1,'Roberval Lírio'),(2,'Aretha Coautora'),(3,'Frank Sorriso'),(4,'Expert no Assunto'),
(5, 'Professora Renata Silva');

insert into estoque values (1,1,13), (1,2,5);

insert into categoria values (1, 'Romance'), (2,'Autoajuda'),(3,'Fantasia'), (4,'Ficção'),(5,'Não Ficção'),
(6,'Didático'),(7,'Jovem Adulto');

insert into categoria_livro values (1,5,1), (2,2,1), (3,2,2), (4,4,2),(5,6,3),(6,5,3), (7,3,4),(8,4,4), (9,7,4);

insert into autor_livro values (1,3,1),(2,1,2), (3,2,2),(4,5,3),(5,3,4);

--inserir clientes
insert into cliente values (1,'majoaquina@gmail.com','Maria Joaquina',null,'11987654321'),
(2,'luciocarlos@hotmail.com','Lucio','1135778989','11981007788');

--inserir enderecos
insert into endereco values (1,'Parque Nações Unidas','08999-000','São Paulo','Rua do Ipê Amarelo, 72 Apto 12B','SP'),
(2,'Bairro Vermelho','08122-000','São Paulo','Avenida Brasil, 5980 B','SP');

insert into pf values (1,'65999193087','181187474');
insert into pj values (2,'41152621000178','515687508254');

insert into pedido values (1,date('2022-10-25'), 'CONCLUIDO',49,1);

insert into pedido_livro values (2,1,2);

