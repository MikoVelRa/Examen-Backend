/* Creación de la base de datos, tablas, etc*/

CREATE DATABASE Los_Grandes_Almacenes;

USE Los_Grandes_Almacenes;

CREATE TABLE Cajeros(
	Cajero smallint NOT NULL PRIMARY KEY,
	NomApels varchar(255)
);


CREATE TABLE Productos(
	Producto smallint NOT NULL PRIMARY KEY,
	Nombre varchar(100),
	Precio money
);


CREATE TABLE Maquinas_Registradoras(
	Maquina smallint NOT NULL PRIMARY KEY,
	Piso smallint
);


CREATE TABLE Venta(
	Cajero smallint NOT NULL,
	Maquina smallint NOT NULL,
	Producto smallint NOT NULL
);
