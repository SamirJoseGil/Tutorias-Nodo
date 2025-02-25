-- Crear la tabla Libro en PostgreSQL
CREATE TABLE Libro (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descripcion TEXT,
    author_id INTEGER NOT NULL,
    FOREIGN KEY (author_id) REFERENCES Author(id)
);

-- Crear la tabla Prueba en PostgreSQL
CREATE TABLE Prueba (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    edad INT,
    correo VARCHAR(100),
    fecha_nacimiento DATE
);

-- Crear la tabla Usuario en PostgreSQL
CREATE TABLE ourusers (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    city VARCHAR(255),
    role VARCHAR(50) NOT NULL
);

CREATE TABLE author (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);