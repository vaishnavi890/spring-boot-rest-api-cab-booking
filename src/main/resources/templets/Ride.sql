CREATE TABLE IF NOT EXISTS rides (
    ride_id INT PRIMARY KEY,
    user_id INT,
    driver_id INT,
    pickup_location VARCHAR(255),
    dropoff_location VARCHAR(255),
    fare DOUBLE,
    status VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (driver_id) REFERENCES drivers(driver_id)
);

INSERT INTO rides (ride_id, user_id, driver_id, pickup_location, dropoff_location, fare, status)
VALUES (201, 1, 101, 'MG Road, Pune', 'Shivaji Nagar, Pune', 250.00, 'completed');
