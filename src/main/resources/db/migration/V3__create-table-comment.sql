CREATE TABLE comments (
    id VARCHAR(50) PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,

    user_id VARCHAR(50) NOT NULL,
    publication_id VARCHAR(50) NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users(id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (publication_id) REFERENCES publications(id) ON UPDATE CASCADE ON DELETE CASCADE
);
