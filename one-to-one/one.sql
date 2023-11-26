create table cargos (
	codigo SERIAL PRIMARY KEY,
	cargo VARCHAR (255),
	salario VARCHAR (255)
);


CREATE TABLE colaboradores (
	codigo serial PRIMARY KEY,
	nome VARCHAR (255),
	cargo int REFERENCES cargos(codigo) 
);

select * from colaboradores;

select * from cargos;

