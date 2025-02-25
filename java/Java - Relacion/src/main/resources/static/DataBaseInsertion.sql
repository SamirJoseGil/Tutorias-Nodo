-- Insertar datos en la tabla Libro
-- Inserta datos en la tabla Libro
INSERT INTO Libro (titulo, descripcion, author_id)
VALUES 
    ('Cien Años de Soledad', 'Una obra maestra de Gabriel García Márquez sobre la familia Buendía en Macondo.', 1),
    ('El amor en los tiempos del cólera', 'Una historia de amor épica en tiempos de cólera y pasión.', 1),
    ('La Metamorfosis', 'Franz Kafka cuenta la extraña historia de un hombre que se convierte en un insecto.', 2),
    ('1984', 'Una novela distópica sobre un estado totalitario que controla todo aspecto de la vida.', 3),
    ('Fahrenheit 451', 'Ray Bradbury describe un mundo donde los libros están prohibidos y quemados.', 4);


-- Insertar datos en la tabla Prueba
INSERT INTO Prueba (nombre, apellido, edad, correo, fecha_nacimiento) VALUES
('Juan', 'Pérez', 25, 'juan.perez@example.com', '1999-04-15'),
('María', 'Gómez', 30, 'maria.gomez@example.com', '1994-07-20'),
('Carlos', 'Rodríguez', 28, 'carlos.rodriguez@example.com', '1996-01-10'),
('Laura', 'Martínez', 22, 'laura.martinez@example.com', '2002-11-05'),
('José', 'López', 35, 'jose.lopez@example.com', '1989-08-13'),
('Ana', 'Fernández', 27, 'ana.fernandez@example.com', '1997-03-22'),
('Miguel', 'Hernández', 33, 'miguel.hernandez@example.com', '1991-12-09'),
('Lucía', 'Ruiz', 26, 'lucia.ruiz@example.com', '1998-05-16'),
('Pedro', 'Jiménez', 29, 'pedro.jimenez@example.com', '1995-10-25'),
('Claudia', 'Castro', 24, 'claudia.castro@example.com', '2000-06-30');

-- Insertar datos en la tabla Author
INSERT INTO author (name, lastname, email) VALUES
('J.K.', 'Rowling', 'jk.rowling@example.com'),
('George', 'Orwell', 'george.orwell@example.com'),
('Harper', 'Lee', 'harper.lee@example.com');

