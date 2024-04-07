CREATE TABLE planes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    model VARCHAR(255) NOT NULL,
    capacity INT NOT NULL
);

CREATE TABLE flights (
    id INT PRIMARY KEY AUTO_INCREMENT,
    destination VARCHAR(255) NOT NULL,
    departureDate DATE NOT NULL,
    departureTime TIME NOT NULL,
    idPlane INT,
    CONSTRAINT fk_idPLane FOREIGN KEY (idPlane)
        REFERENCES planes (id)
        ON DELETE CASCADE
);

CREATE TABLE passengers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    identityDocument VARCHAR(255) NOT NULL
);

CREATE TABLE reservations (
    id INT PRIMARY KEY AUTO_INCREMENT,
    reservationDate DATE NOT NULL,
    seat VARCHAR(2) NOT NULL,
    idPassenger INT,
    idFlight INT,
    CONSTRAINT fk_idPassenger FOREIGN KEY (idPassenger)
        REFERENCES passengers (id)
        ON DELETE CASCADE,
    CONSTRAINT fk_idFlight FOREIGN KEY (idFlight)
        REFERENCES flights (id)
        ON DELETE CASCADE
);

INSERT INTO planes (model, capacity) VALUES 
('Boeing 737', 180),
('Airbus A320', 150),
('Boeing 787', 250);

INSERT INTO flights (destination, departureDate, departureTime, idPlane) VALUES
('New York', '2024-04-10', '08:00:00', 1),
('Los Angeles', '2024-04-12', '10:30:00', 2),
('London', '2024-04-15', '14:00:00', 3);

INSERT INTO passengers (name, lastName, identityDocument) VALUES
('John', 'Doe', 'ABC12345'),
('Jane', 'Smith', 'DEF67890'),
('Michael', 'Johnson', 'GHI54321');

INSERT INTO reservations (reservationDate, seat, idPassenger, idFlight) VALUES
('2024-04-08', 'A1', 1, 1),
('2024-04-10', 'B3', 2, 2),
('2024-04-14', 'C2', 3, 3);

DROP TABLE reservations;
DROP TABLE flights;
DROP TABLE passengers;
DROP TABLE planes;




