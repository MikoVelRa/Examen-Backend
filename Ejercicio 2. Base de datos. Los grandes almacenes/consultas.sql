/* Querys - Consultas */

/* 1. Generar script para poblar todas las tablas */

INSERT INTO 
	Cajeros (nomapels)
VALUES 
	('Juan Pérez González'),
	('Sofía Mercado Nava'),
	('Julián Alexander Montiel Saavedra'),
	('Romina Gutiérrez Soto'),
	('Francisco Alarcón Madrid'),
	('Angélica Rivera Ramírez'),
	('José Yair Velázquez Tolentino'),
	('María Meza Machado'),
	('Arturo Higuera López'),
	('Tatiana De las Salas Martínez');

/* ----------------------------------- */

INSERT INTO 
	Productos (Nombre, Precio)
VALUES 
	('Arroz Morelos (caja)', 300.00),
	('Frijol Bayo (caja)', 280.00),
	('Leche Entera Aplura (caja)', 200.00),
	('Aceite Kártamus (caja)', 200.00),
	('Garbanzo Herdez (kg.)', 60.00),
	('Papel Higiénico Pétalo (caja)', 380.00),
	('Servilletas El Rey (caja)', 300.00),
	('Jabón para trastes Axión', 25.00),
	('Kilo de lenteja', 58.00),
	('Veladora chica (caja)', 230.00),
	('Veladora mediana (caja)', 320.00),
	('Veladora grande (caja)', 360.00),
	('Kilo de Queso Oaxaca', 80.00),
	('Litro de crema LALA', 9.00),
	('Detergente 123 (caja)', 169.00),
	('Paquete de cerillos Flama (5 cajas)', 43.00),
	('Huevo San Juan (caja de 360 pz.)', 1200.00),
	('Pasta de dientes Colgate Sensitive Protection', 58.00),
	('Escoba', 10.00),
	('Cubeta', 34.00);

INSERT INTO
	maquinas_registradoras (piso)
VALUES
	(2), (4), (1), (2), (3), (1), (4), (3), (3), (2);

INSERT INTO
	venta (Cajero, Maquina, Producto)
VALUES
	(1, 3, 1),
	(1, 3, 9),
	(1, 3, 13),
	(1, 3, 3),
	(4, 3, 11),
	(4, 3, 18),
	(2, 1, 6),
	(2, 1, 6),
	(2, 1, 15),
	(2, 1, 20),
	(3, 4, 1),
	(3, 4, 2),
	(3, 4, 2),
	(3, 4, 3),
	(3, 4, 6),
	(3, 4, 12),
	(3, 4, 14),
	(5, 2, 19),
	(5, 2, 19),
	(5, 2, 19),
	(5, 2, 12),
	(5, 2, 11),
	(5, 2, 13),
	(5, 2, 13),
	(5, 2, 17),
	(6, 2, 20),
	(6, 2, 20),
	(6, 2, 20),
	(6, 2, 4),
	(6, 2, 8),
	(6, 2, 8),
	(6, 2, 16),
	(6, 2, 18),
	(7, 3, 1),
	(7, 3, 16),
	(7, 3, 18),
	(7, 3, 10),
	(7, 3, 17),
	(8, 1, 16),
	(8, 1, 5),
	(8, 1, 5),
	(8, 1, 5),
	(8, 1, 5),
	(8, 1, 5),
	(8, 1, 6),
	(8, 1, 6),
	(8, 1, 6),
	(8, 1, 6),
	(9, 3, 10),
	(9, 3, 11),
	(9, 3, 12),
	(9, 3, 10),
	(9, 3, 14),
	(9, 3, 14),
	(9, 3, 14),
	(10, 2, 7),
	(10, 2, 7),
	(10, 2, 7),
	(10, 2, 7),
	(10, 2, 19),
	(10, 2, 17),
	(1, 2, 7),
	(1, 2, 8),
	(1, 2, 6),
	(1, 2, 2),
	(1, 2, 3),
	(1, 2, 1),
	(1, 2, 5),
	(1, 2, 6),
	(1, 2, 17),
	(5, 2, 6),
	(5, 2, 8),
	(3, 3, 3),
	(3, 3, 13),
	(3, 3, 18),
	(3, 3, 1),
	(7, 4, 7),
	(7, 4, 7),
	(7, 4, 8),
	(7, 4, 7),
	(7, 4, 9),
	(6, 4, 7),
	(2, 2, 2),
	(3, 3, 3),
	(9, 5, 12),
	(9, 5, 1),
	(9, 5, 9),
	(10, 9, 14),
	(10, 9, 18),
	(10, 9, 17),
	(10, 9, 8),
	(10, 9, 3),
	(4, 8, 19),
	(4, 8, 19),
	(4, 8, 20),
	(4, 8, 3);

/* 2. Mostrar el número de ventas de cada producto, ordenado de más a menos ventas. */
SELECT p.nombre, COUNT(*) as numero_de_ventas FROM venta v
INNER JOIN productos p
ON v.producto = p.producto
GROUP BY p.nombre
ORDER BY numero_de_ventas DESC;

/* 3. Obtener un informe completo de ventas, indicando el nombre del cajero que realizó la venta, 
nombre y precios de los productos vendidos, y el piso en el que se encuentra la máquina registradora 
donde se realizó la venta.*/

SELECT c.nomapels, p.nombre, p.precio, m.maquina, m.piso FROM venta v
INNER JOIN cajeros c
ON v.cajero = c.cajero
INNER JOIN productos p
ON v.producto = p.producto
INNER JOIN maquinas_registradoras m
ON v.maquina = m.maquina;

/* 4. Obtener las ventas totales realizadas en cada piso. */
SELECT m.piso, SUM(p.precio) as Ventas_Totales FROM venta v
INNER JOIN maquinas_registradoras m
ON v.maquina = m.maquina
INNER JOIN productos p
ON v.producto = p.producto
GROUP BY m.piso
ORDER BY m.piso;

/* 5. Obtener el código y nombre de cada cajero junto con el importe total de sus ventas */
SELECT c.cajero, c.nomapels, SUM(p.precio) as Importe_Total_Ventas FROM venta v
INNER JOIN productos p
ON v.producto = p.producto
INNER JOIN cajeros c
ON v.cajero = c.cajero
GROUP BY c.cajero, c.nomapels
ORDER BY c.cajero;

/* 6. Obtener el código y nombre de aquellos cajeros que hayan realizado ventas en pisos 
cuyas ventas totales sean inferiores a los 5000 pesos. */

SELECT DISTINCT c.cajero, c.nomapels from venta v 
INNER JOIN cajeros c
ON v.cajero = c.cajero
WHERE maquina IN (
	SELECT maquina from maquinas_registradoras WHERE piso IN (
		SELECT m.piso FROM venta v
		INNER JOIN maquinas_registradoras m
		ON v.maquina = m.maquina
		INNER JOIN productos p
		ON v.producto = p.producto
		GROUP BY m.piso
		HAVING SUM(p.precio) < 5000::float8::numeric::money
	)
)
ORDER BY c.cajero;