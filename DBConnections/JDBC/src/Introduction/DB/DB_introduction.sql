CREATE DATABASE _01_jdbc;

use _01_jdbc;

CREATE TABLE coder (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    age INT NOT NULL,
    clan VARCHAR(40) NOT NULL
)

INSERT INTO coder(name,age,clan)VALUES("Jhonatan Toro Hurtado",21,"Meta"),
("Ana Maria Restrepo Quintero",27,"Meta"),("Prueba Pepito Perez",20,"Lovelace");

SELECT 
    *
FROM
    coder;
    
DROP TABLE coder;