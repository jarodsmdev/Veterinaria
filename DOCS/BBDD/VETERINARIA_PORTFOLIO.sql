DROP DATABASE IF EXISTS VETERINARIA_PORTFOLIO;

CREATE DATABASE IF NOT EXISTS VETERINARIA_PORTFOLIO;

USE VETERINARIA_PORTFOLIO;

-- Crea la tabla 'users' que almacena la información de los usuarios
-- La tabla tiene tres columnas: username, password y enabled
-- username: Nombre de usuario. Es único y no puede ser nulo
-- password: Contraseña del usuario. No puede ser nula
-- enabled: Indica si la cuenta del usuario está habilitada o deshabilitada
-- La tabla utiliza el motor InnoDB y la clave primaria es username
DROP TABLE IF EXISTS users;
CREATE TABLE users(
	username VARCHAR(50) NOT NULL UNIQUE,
	password VARCHAR(128) NOT NULL,
	enabled TINYINT(1) NOT NULL,
	PRIMARY KEY (username)
) ENGINE=InnoDB;

-- Inserta algunos datos de prueba en la tabla 'users'
-- Los datos de prueba son el usuario 'Admin' y otros cuatro usuarios con nombres diferentes
-- Todas las contraseñas son '123' y todas las cuentas están habilitadas
INSERT INTO users
VALUES
('Admin', '$2a$10$/YoeJjW5u7KwfO7KKv59k.xm/iuqTM6NRR3jEOZ.Lb7W/LEx2pL3W', 1),
('Leonel', '$2a$10$/YoeJjW5u7KwfO7KKv59k.xm/iuqTM6NRR3jEOZ.Lb7W/LEx2pL3W', 1),
('Viviana', '$2a$10$/YoeJjW5u7KwfO7KKv59k.xm/iuqTM6NRR3jEOZ.Lb7W/LEx2pL3W', 1),
('Antonella', '$2a$10$/YoeJjW5u7KwfO7KKv59k.xm/iuqTM6NRR3jEOZ.Lb7W/LEx2pL3W', 1),
('Isidora', '{noop}123', 1);

-- Crea la tabla 'authorities' que almacena los roles de los usuarios
-- La tabla tiene dos columnas: username y authority
-- La tabla utiliza el motor InnoDB y tiene una clave única compuesta por username y authority
-- También tiene una clave foránea que hace referencia a la columna username de la tabla users
DROP TABLE IF EXISTS authorities;
CREATE TABLE authorities (
	username VARCHAR(50) NOT NULL,
	authority VARCHAR(50) NOT NULL,
	UNIQUE KEY authorities_idx_1 (username, authority),
	CONSTRAINT authorities_ibfk_1 FOREIGN KEY (username)
    REFERENCES users (username) ON DELETE CASCADE
) ENGINE=InnoDB;

-- Inserta algunos datos de prueba en la tabla 'authorities'
-- Asigna diferentes roles a los usuarios creados anteriormente
-- El usuario 'Admin' tiene los roles de 'ROLE_USUARIO' y 'ROLE_ADMINISTRADOR'
-- Los demás usuarios tienen el rol de 'ROLE_USUARIO' y 'ROLE_AYUDANTE' o 'ROLE_ADMINISTRADOR' dependiendo del caso
INSERT INTO authorities
VALUES 
('Admin','ROLE_USUARIO'),
('Admin','ROLE_ADMINISTRADOR'),
('Isidora','ROLE_USUARIO'),
('Antonella','ROLE_USUARIO'),
('Viviana','ROLE_AYUDANTE'),
('Leonel','ROLE_USUARIO'),
('Leonel','ROLE_ADMINISTRADOR');

-- La tabla 'especie' almacena los nombres de las especies de los pacientes.
-- Es referenciada por la tabla 'paciente' mediante la clave foránea 'idEspecie'.
DROP TABLE IF EXISTS especie;
CREATE TABLE especie(
	idEspecie INT AUTO_INCREMENT PRIMARY KEY,
    especie VARCHAR(30) NOT NULL
) ENGINE=InnoDB;

-- La tabla 'cliente' almacena información sobre los clientes de la veterinaria.
-- Está relacionada con la tabla 'telefono' mediante la clave foránea 'idTelefono',
-- y con la tabla 'paciente' mediante la clave foránea 'idCliente'.
DROP TABLE IF EXISTS cliente;
CREATE TABLE cliente(
	idCliente INT AUTO_INCREMENT PRIMARY KEY,
    rutCliente VARCHAR(20),
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    telefono VARCHAR(50),
    direccion VARCHAR(50),
    email VARCHAR(30)
) ENGINE=InnoDB;

-- La tabla 'paciente' almacena información sobre los pacientes de la veterinaria.
-- Está relacionada con la tabla 'cliente' mediante la clave foránea 'idCliente',
-- y con la tabla 'especie' mediante la clave foránea 'idEspecie'.
DROP TABLE IF EXISTS paciente;
CREATE TABLE paciente(
	idPaciente INT AUTO_INCREMENT PRIMARY KEY,
    idCliente INT NOT NULL, /*FK CLIENTE OK*/
    idEspecie INT NOT NULL, /*FK ESPECIE OK*/
    nombre VARCHAR(50),
    genero VARCHAR(50),
    color VARCHAR(20),
    peso INT,
    observaciones VARCHAR(255),
    fechaNacimiento DATE
) ENGINE=InnoDB;

-- La tabla 'atencion' almacena información sobre las atenciones que se realizan en la veterinaria.
-- Está relacionada con la tabla 'paciente' mediante la clave foránea 'idPaciente',
-- con la tabla 'servicio' mediante la clave foránea 'idServicio',
-- y con la tabla 'users' mediante la clave foránea 'username'.
DROP TABLE IF EXISTS atencion;
CREATE TABLE atencion(
	idAtencion INT AUTO_INCREMENT PRIMARY KEY,
    idPaciente INT NOT NULL, /*FK PACIENTE OK*/
    idServicio INT NOT NULL, /*FK SERVICIO OK*/
    username VARCHAR(50) NOT NULL, /*FK USERS OK*/
    fechaAtencion DATE
) ENGINE=InnoDB;

-- La tabla 'servicio' almacena los diferentes servicios ofrecidos por la veterinaria.
-- Es referenciada por la tabla 'atencion' mediante la clave foránea 'idServicio'.
DROP TABLE IF EXISTS servicio;
CREATE TABLE servicio(
	idServicio INT AUTO_INCREMENT PRIMARY KEY,
    servicio VARCHAR(30) NOT NULL,
    valor INT NOT NULL DEFAULT 0
) ENGINE=InnoDB;

/* CREACION DE LLAVES FORANEAS TABLA PACIENTE */
ALTER TABLE paciente
ADD CONSTRAINT paciente_idfk_1 FOREIGN KEY (idCliente) REFERENCES cliente (idCliente),
ADD CONSTRAINT paciente_idfk_2 FOREIGN KEY (idEspecie) REFERENCES especie (idEspecie);

/* CREACION DE LLAVES FORANEAS TABLA ATENCION */
ALTER TABLE atencion
ADD CONSTRAINT atencion_idfk_1 FOREIGN KEY (idPaciente) REFERENCES paciente (idPaciente),
ADD CONSTRAINT atencion_idfk_2 FOREIGN KEY (idServicio) REFERENCES servicio (idServicio),
ADD CONSTRAINT atencion_idfk_3 FOREIGN KEY (username) REFERENCES users (username);

SELECT * FROM cliente order by apellido;

SELECT * FROM users
INNER JOIN authorities
ON users.username = authorities.username;

select * from cliente;


