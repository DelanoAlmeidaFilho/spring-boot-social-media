CREATE TABLE followers (
    follower VARCHAR(50) NOT NULL,
    followed VARCHAR(50) NOT NULL,

    PRIMARY KEY (follower, followed),
    FOREIGN KEY (follower) REFERENCES users(id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (followed) REFERENCES users(id) ON UPDATE CASCADE ON DELETE CASCADE
);
