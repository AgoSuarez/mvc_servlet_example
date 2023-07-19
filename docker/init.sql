CREATE DATABASE `control_clientes;

-- control_clientes.cliente definition

CREATE TABLE control_clientes.cliente (
	id_cliente INT auto_increment NOT NULL,
	nombre varchar(45) NULL,
	apellido varchar(45) NULL,
	email varchar(45) NULL,
	telefono varchar(45) NULL,
	saldo DOUBLE NULL,
	CONSTRAINT cliente_PK PRIMARY KEY (id_cliente)
)



INSERT INTO control_clientes.cliente
(id_cliente, nombre, apellido, email, telefono, saldo)
VALUES(1, 'Juan', 'Perez', 'jperez@mail.com', '1122-3344', 100.0);
INSERT INTO control_clientes.cliente
(id_cliente, nombre, apellido, email, telefono, saldo)
VALUES(2, 'Karla', 'Gomez', 'kgomez@mail.com', '4433-2211', 250.0);


