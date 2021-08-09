/* Creación de la base de datos, tablas, etc*/

CREATE DATABASE Los_Grandes_Almacenes;

USE Los_Grandes_Almacenes;

CREATE TABLE Cajeros(
	Cajero int NOT NULL PRIMARY KEY,
	NomApels varchar(255)
);


CREATE TABLE Productos(
	Producto INT NOT NULL PRIMARY KEY,
	Nombre varchar(100),
	Precio double(8,2)
);


CREATE TABLE Maquinas_Registradoras(
	Maquina INT NOT NULL PRIMARY KEY,
	Piso int
);


CREATE TABLE Venta(
	Cajero INT NOT NULL,
	Maquina INT NOT NULL,
	Producto INT NOT NULL
);