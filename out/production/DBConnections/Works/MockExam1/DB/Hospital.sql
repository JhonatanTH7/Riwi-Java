
CREATE TABLE specialties (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    description VARCHAR(500) NOT NULL
);

CREATE TABLE physicians (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    lastName VARCHAR(40) NOT NULL,
    idSpecialty INT NOT NULL,
    CONSTRAINT fk_idSpecialty FOREIGN KEY (idSpecialty)
        REFERENCES specialties (id)
        ON DELETE CASCADE
);

CREATE TABLE patients (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    lastName VARCHAR(40) NOT NULL,
    dateOfBirth DATE NOT NULL,
    identityDocument VARCHAR(40) NOT NULL
);

CREATE TABLE appointments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    idPatient INT NOT NULL,
    idPhysician INT,
    appointmentDate DATE NOT NULL,
    appointmentTime TIME NOT NULL,
    reason VARCHAR(40) NOT NULL,
    CONSTRAINT fk_idPatient FOREIGN KEY (idPatient)
        REFERENCES patients (id)
        ON DELETE CASCADE,
    CONSTRAINT fk_idPhysician FOREIGN KEY (idPhysician)
        REFERENCES physicians (id)
);


INSERT INTO specialties (name, description) VALUES 
('Pediatría', 'Especialidad médica que se dedica al estudio de los niños y sus enfermedades.'),
('Cardiología', 'Especialidad médica que se dedica al estudio, diagnóstico y tratamiento de las enfermedades del corazón y del aparato circulatorio.'),
('Dermatología', 'Especialidad médica que se dedica al estudio de la piel, sus estructuras, funciones y enfermedades.'),
('Ginecología', 'Especialidad médica que se dedica al estudio del sistema reproductor femenino.');

INSERT INTO physicians (name, lastName, idSpecialty) VALUES
('Juan', 'Gómez', 1),
('María', 'López', 3),
('Carlos', 'Martínez', 2),
('Laura', 'García', 4);

INSERT INTO patients (name, lastName, dateOfBirth, identityDocument) VALUES
('Ana', 'Pérez', '2000-05-15', '12345678A'),
('Luis', 'Rodríguez', '1995-10-20', '87654321B'),
('Elena', 'González', '1983-03-08', '98765432C'),
('Mario', 'Sánchez', '1978-12-30', '23456789D');

INSERT INTO appointments (idPatient, idPhysician, appointmentDate, appointmentTime, reason) VALUES
(1, 1, '2024-04-10', '10:00:00', 'Control pediátrico'),
(2, 3, '2024-04-12', '15:30:00', 'Consulta por dermatitis'),
(3, 4, '2024-04-15', '11:45:00', 'Consulta ginecológica'),
(4, 2, '2024-04-20', '09:15:00', 'Revisión cardiológica');

DROP TABLE specialties;
DROP TABLE physicians;
DROP TABLE patients;
DROP TABLE appointments;

SELECT 
    *
FROM
    appointments;


