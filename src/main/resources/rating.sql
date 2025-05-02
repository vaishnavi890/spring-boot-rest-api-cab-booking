CREATE TABLE IF NOT EXISTS ratings (
    rating_id INT PRIMARY KEY,
    ride_id INT,
    user_id INT,
    driver_id INT,
    rating INT,
    review TEXT,
    FOREIGN KEY (ride_id) REFERENCES rides(ride_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (driver_id) REFERENCES drivers(driver_id)
);

INSERT INTO ratings (rating_id, ride_id, user_id, driver_id, rating, review)
VALUES (401, 201, 1, 101, 5, 'Excellent service and clean cab!');
