CREATE TABLE IF NOT EXISTS users (
    user_id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(20)
);

INSERT INTO users (user_id, name, email, phone)
VALUES (1, 'Alice Smith', 'alice@example.com', '9876543210');
