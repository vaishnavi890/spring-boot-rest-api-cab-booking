CREATE TABLE IF NOT EXISTS payments (
    payment_id INT PRIMARY KEY,
    ride_id INT,
    user_id INT,
    amount DOUBLE,
    payment_method VARCHAR(50),
    status VARCHAR(50),
    FOREIGN KEY (ride_id) REFERENCES rides(ride_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

INSERT INTO payments (payment_id, ride_id, user_id, amount, payment_method, status)
VALUES (301, 201, 1, 250.00, 'Credit Card', 'successful');
