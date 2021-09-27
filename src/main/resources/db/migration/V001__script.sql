create table funcao(
    id int not null primary key,
    nome varchar(20),
    is_ativo boolean default true
);

create table perfil(
    id int not null primary key,
    nome varchar(20),
    is_ativo boolean default true
);

create table usuario (
    id int not null primary key,
    nome varchar(50),
    email varchar(255),
    cpf varchar(14) unique,
    telefone  varchar(15),
    funcao_id int,
    perfil_id int,
    is_ativo  boolean,
    constraint funcao_fk_usuario foreign key (funcao_id) references funcao(id),
    constraint perfil_fk_usuario foreign key (perfil_id) references perfil(id)
);