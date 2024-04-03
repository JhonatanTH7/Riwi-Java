CREATE TABLE authors (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    nationality VARCHAR(50) NOT NULL
);

CREATE TABLE books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(80) NOT NULL,
    publicationYear INT NOT NULL,
    price DOUBLE NOT NULL,
    idAuthor INT NOT NULL,
    FOREIGN KEY (idAuthor)
        REFERENCES authors (id) ON DELETE CASCADE
);

INSERT INTO authors (name, nationality) VALUES
('Gabriel García Márquez', 'Colombiana'),
('Mario Vargas Llosa', 'Peruana'),
('Julio Cortázar', 'Argentino'),
('Jorge Luis Borges', 'Argentino'),
('Pablo Neruda', 'Chileno'),
('Isabel Allende', 'Chilena'),
('Carlos Fuentes', 'Mexicano'),
('Octavio Paz', 'Mexicano'),
('Miguel de Cervantes', 'Español'),
('Federico García Lorca', 'Español'),
('Jorge Amado', 'Brasileño'),
('Clarice Lispector', 'Brasileña'),
('José Saramago', 'Portugués'),
('Fernando Pessoa', 'Portugués'),
('Gustavo Adolfo Bécquer', 'Español'),
('Antonio Machado', 'Español'),
('Rubén Darío', 'Nicaragüense'),
('Horacio Quiroga', 'Uruguayo'),
('Juan Rulfo', 'Mexicano'),
('Alfonsina Storni', 'Argentino'),
('Pablo de Rokha', 'Chileno'),
('José Martí', 'Cubano'),
('César Vallejo', 'Peruano'),
('Mariano Azuela', 'Mexicano'),
('Rosario Castellanos', 'Mexicano'),
('Javier Marías', 'Español'),
('Manuel Puig', 'Argentino'),
('Camilo José Cela', 'Español'),
('Juan Carlos Onetti', 'Uruguayo'),
('Leopoldo Marechal', 'Argentino');

INSERT INTO books (title, publicationYear, price, idAuthor) VALUES
('Cien años de soledad', 1967, 25.99, 1),
('La casa verde', 1966, 20.50, 2),
('Rayuela', 1963, 18.75, 3),
('Ficciones', 1944, 15.25, 4),
('Veinte poemas de amor y una canción desesperada', 1924, 12.99, 5),
('La casa de los espíritus', 1982, 21.50, 6),
('Aura', 1962, 17.95, 7),
('El laberinto de la soledad', 1950, 14.75, 8),
('Don Quijote de la Mancha', 1605, 10.99, 9),
('Bodas de sangre', 1933, 13.50, 10),
('Dona Flor y sus dos maridos', 1966, 19.75, 11),
('La hora de la estrella', 1977, 16.95, 12),
('Ensayo sobre la ceguera', 1995, 23.95, 13),
('El libro del desasosiego', 1982, 20.25, 14),
('Rimas y leyendas', 1871, 11.99, 15),
('Soledades, galerías y otros poemas', 1907, 9.75, 16),
('Azul...', 1888, 12.50, 17),
('Cuentos de la selva', 1918, 10.95, 18),
('Pedro Páramo', 1955, 16.25, 19),
('La playa', 1954, 15.75, 20),
('Los gemidos', 1922, 11.25, 21),
('Versos sencillos', 1891, 8.99, 22),
('Los heraldos negros', 1918, 10.75, 23),
('Los de abajo', 1915, 9.95, 24),
('Balún Canán', 1957, 17.50, 25),
('Mañana en la batalla piensa en mí', 1994, 22.25, 26),
('El beso de la mujer araña', 1976, 19.99, 27),
('La colmena', 1951, 18.25, 28),
('El astillero', 1961, 19.50, 29),
('Adán Buenosayres', 1948, 16.75, 30);

SELECT 
    *
FROM
    authors;
SELECT 
    *
FROM
    books;
DROP TABLE authors;
DROP TABLE books;