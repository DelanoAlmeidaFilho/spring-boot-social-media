CREATE TABLE publications (
    id VARCHAR(50) PRIMARY KEY NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    description TEXT,
    user_id VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON UPDATE CASCADE ON DELETE CASCADE
);
