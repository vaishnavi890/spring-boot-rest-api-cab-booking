CREATE TABLE IF NOT EXISTS drivers (
    driver_id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(20),
    cab_details VARCHAR(255)
);

INSERT INTO drivers (driver_id, name, email, phone, cab_details)
VALUES (101, 'Bob Driver', 'bob.driver@example.com', '9988776655', 'Toyota Prius - MH12AB1234');
