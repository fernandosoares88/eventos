insert into role (id, nome) values 
	(1, 'ROLE_ADMIN')
	, (2, 'ROLE_USUARIO')
	, (3, 'ROLE_AVALIADOR')
;

/* Senha '123' criptografada */
insert into usuario (id, nome, matricula, email, senha) values
	(1, 'Administrador', '123', 'admin@email.com', '$2a$10$kbag8mN5lAMNaT2erIn4geA/ZoloBUGuv2HPaAHBvjCi8SbMApdDq') 	
;

insert into usuario_roles (usuario_id, roles_id) values
	(1, 1);