SET LC_MONETARY = 'es_MX';

SELECT * FROM Venta;


TRUNCATE TABLE Venta;

SELECT SUM(p.precio), m.maquina FROM Venta v
INNER JOIN productos p
ON v.producto = p.producto
INNER JOIN maquinas_registradoras m
ON v.maquina = m.maquina
WHERE m.maquina IN (3,6)
GROUP BY m.maquina;

SELECT COUNT(p.precio) as total_venta,  FROM venta v
INNER JOIN productos p
ON v.producto = p.producto
WHERE maquina IN (2,7)
GROUP BY v.producto, p.precio, p.nombre
ORDER BY p.nombre ASC;

SELECT * FROM venta WHERE cajero = 10;