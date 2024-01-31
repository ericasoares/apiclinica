  create table endereco(
      id bigint not null auto_increment,
      logradouro varchar(100) not null,
      bairro varchar(100) not null,
      cep varchar(9) not null,
      complemento varchar(100),
      numero varchar(20),
      uf char(2) not null,
      cidade varchar(100) not null,
      primary key(id)
  );