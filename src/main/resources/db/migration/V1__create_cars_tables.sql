CREATE TABLE cars(

id BIGSERIAL PRIMARY KEY,
brand VARCHAR(100) NOT NULL,
model VARCHAR(100) NOT NULL,
year int NOT NULL,
license_plate VARCHAR(20) UNIQUE NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);

INSERT INTO cars (brand, model, year, license_plate) VALUES

('Nissan', 'Skyline GT-R R32', 1989, 'A123BC'),
('VAZ', '2107' , 2007, 'X123EP');