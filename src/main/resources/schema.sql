DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id      int PRIMARY KEY,
    name    varchar(255),
    region  varchar(255),
    balance int
);