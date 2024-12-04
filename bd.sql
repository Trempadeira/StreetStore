CREATE DATABASE street_store;

USE street_store;

CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(25),
    email VARCHAR(60),
    password TEXT,
    city VARCHAR(35),
    phone_number VARCHAR(13),
    neighborhood VARCHAR(20)
);

INSERT INTO usuarios (name, email, password, city, phone_number, neighborhood)
VALUES 
('admin', 'admin@admin.com', SHA1('ADM@123'), 'Ouro Preto', '51999128332', 'Belo Horizonte');
