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


-- Desencadenador para garantizar que no se exceda la capacidad del avión
DELIMITER //
CREATE TRIGGER before_reservation_insert
BEFORE INSERT ON reservations
FOR EACH ROW
BEGIN
    DECLARE current_capacity INT;
    DECLARE reservations_count INT;
    
    -- Obtener la capacidad del avión para el vuelo asociado a la reserva
    SELECT capacity INTO current_capacity
    FROM planes
    WHERE id = (SELECT idPlane FROM flights WHERE id = NEW.idFlight);

    -- Contar el número de reservaciones existentes para el vuelo asociado
    SELECT COUNT(*) INTO reservations_count
    FROM reservations
    WHERE idFlight = NEW.idFlight;

    -- Verificar si el número de reservaciones supera la capacidad del avión
    IF reservations_count >= current_capacity THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'MAX capacity reached, can not make more reservations';
    END IF;
END;
//
DELIMITER ;

-- Desencadenador para evitar reservar un asiento ya ocupado
DELIMITER //
CREATE TRIGGER before_reservation_insert
BEFORE INSERT ON reservations
FOR EACH ROW
BEGIN
    DECLARE existing_reservation_count INT;
    
    -- Contar el número de reservaciones existentes para el mismo vuelo y asiento
    SELECT COUNT(*) INTO existing_reservation_count
    FROM reservations
    WHERE idFlight = NEW.idFlight AND seat = NEW.seat;

    -- Verificar si el asiento ya está reservado
    IF existing_reservation_count > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'This seat is already taken';
    END IF;
END;
//
DELIMITER ;

DROP TRIGGER before_reservation_insert;



