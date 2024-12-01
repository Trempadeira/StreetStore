CREATE DATABASE street_store;

USE street_store;

CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    city VARCHAR(255),
    phone_number VARCHAR(20),
    neighborhood VARCHAR(255)
);

INSERT INTO usuarios (name, email, password, city, phone_number, neighborhood)
VALUES 
('admin', 'admin@admin.com', SHA1('ADM@123'), 'Ouro Preto', '51999128332', 'Belo Horizonte');
