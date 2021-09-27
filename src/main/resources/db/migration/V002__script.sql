insert into funcao(id, nome, is_ativo) values
(1, 'Administrador', true),
(2, 'Gerente', true),
(3, 'Secretária', true),
(4, 'Operador', true);

insert into perfil(id, nome, is_ativo) values
(1, 'Gestor Nacional', true),
(2, 'Gestor Estadual', true),
(3, 'Gestor Municipal', true);

insert into usuario (id, nome, email, cpf, telefone, funcao_id, perfil_id, is_ativo) values
(1, 'Otávio Tiago Campos', 'otaviotiagocampos-93@saboia.me', '177.149.533-22', '(79) 98432-5642', 1, 1, true),
(2, 'Mateus Vinicius Galvão', 'mateusviniciusgalvao..mateusviniciusgalvao@temp.com.br', '523.268.748-46', '(68) 98161-3061', 1, 2, true),
(3, 'Henry Fernando da Luz', 'henryfernandodaluz__henryfernandodaluz@reval.net', '187.210.601-34', '(47) 98755-4794', 1, 2, true);