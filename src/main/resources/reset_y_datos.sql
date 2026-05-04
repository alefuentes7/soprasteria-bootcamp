-- ============================================================
-- 1. Limpieza: eliminar los productos de prueba existentes
-- ============================================================
DELETE FROM producto;

-- ============================================================
-- 2. Reiniciar el AUTO_INCREMENT a 1
-- ============================================================
ALTER TABLE producto AUTO_INCREMENT = 1;

-- ============================================================
-- 3. Insertar productos reales
--    Columnas: nombre, num_serie, fab_com, oferta, precio,
--              coste_prod, tamano, peso, linea, calidad,
--              genero, id_subcat, imagen_url
--    (id_producto se genera automáticamente)
-- ============================================================
INSERT INTO producto (nombre, num_serie, fab_com, oferta, precio, coste_prod, tamano, peso, linea, calidad, genero, id_subcat, imagen_url)
VALUES
  ('Bicicleta MTB Pro', 'MTB-001', true, false, 899.99, 450.00, 'M', 12.50, 1, 5, 1, 1, NULL),
  ('Bicicleta Carretera Racing', 'CAR-002', true, true,  1199.99, 600.00, 'L', 9.80, 2, 5, 1, 2, NULL),
  ('Bicicleta Urbana City', 'URB-003', false, false, 349.99, 175.00, 'S', 14.00, 3, 3, 2, 3, NULL);

-- ============================================================
-- Verificar resultado
-- ============================================================
SELECT id_producto, nombre, num_serie, precio FROM producto ORDER BY id_producto;
