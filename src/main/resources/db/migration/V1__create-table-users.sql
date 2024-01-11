CREATE TABLE users (
    id VARCHAR(50) NOT NULL,
    name VARCHAR(255) UNIQUE,
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    avatar_link VARCHAR(255),
    description TEXT,
    active BOOLEAN,
    role VARCHAR(50),
    PRIMARY KEY (id)
);
