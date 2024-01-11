CREATE TABLE likes (
    user_id VARCHAR(50) NOT NULL,
    publication_id VARCHAR(50) NOT NULL,
    PRIMARY KEY (user_id, publication_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (publication_id) REFERENCES publications(id) ON UPDATE CASCADE ON DELETE CASCADE
);
