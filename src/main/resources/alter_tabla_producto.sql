-- Ejecutar en MySQL para añadir el campo imagen_url a la tabla producto
ALTER TABLE producto
    ADD COLUMN imagen_url VARCHAR(500) NULL;

-- Ejemplo: actualizar la imagen de un producto concreto
-- UPDATE producto SET imagen_url = 'https://mi-dominio.com/imagenes/bici1.jpg' WHERE id_producto = 1;
