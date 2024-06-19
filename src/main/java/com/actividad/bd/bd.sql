-- Creamos la bd 
CREATE DATABASE bd_ejercicio01_S5;
-- activamos la bd
USE bd_ejercicio01_S5;

-- Crear la tabla
CREATE TABLE IF NOT EXISTS producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    precio DOUBLE,
    stock INT,
    fechaVencimiento date
);

/*Los Inserts*/
INSERT INTO producto (nombre, precio, stock, fechaVencimiento) VALUES
('Mouse Razer', 59.99, 150, '2025-12-31'),
('Teclado Corsair', 199.99, 75, '2026-01-15'),
('Monitor ASUS', 699.99, 30, '2027-08-01'),
('Auriculares HyperX', 99.99, 200, '2024-11-20'),
('Tarjeta RTX 3080', 799.99, 50, '2026-06-30'),
('Silla DXRacer', 329.99, 20, '2028-05-10'),
('Controlador Xbox', 179.99, 100, '2026-03-25'),
('Laptop MSI', 1999.99, 10, '2025-09-30'),
('Micrófono Yeti', 129.99, 60, '2026-07-14'),
('Cámara Logitech', 169.99, 45, '2025-02-22');

select * from producto;
