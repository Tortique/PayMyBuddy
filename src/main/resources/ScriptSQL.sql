CREATE DATABASE prod;
USE PROD;

CREATE TABLE users
(
    userId   INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
    email    VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    name     VARCHAR(30)  NOT NULL,
    enabled  TINYINT(4) DEFAULT NULL
);

CREATE TABLE friends
(
    userId   INTEGER NOT NULL,
    friendId INTEGER NOT NULL,
    PRIMARY KEY (userId, friendId),
    FOREIGN KEY (userId)
        REFERENCES users (userId),
    FOREIGN KEY (friendId)
        REFERENCES users (userId)
);

CREATE TABLE account
(
    accountId INTEGER NOT NULL PRIMARY KEY,
    balance   DECIMAL(6, 2)
);

CREATE TABLE transaction
(
    transactionUserId INTEGER       NOT NULL PRIMARY KEY,
    value             DECIMAL(6, 2) NOT NULL,
    comment           VARCHAR(20),
    CONSTRAINT FK_transaction FOREIGN KEY (transactionUserId)
        REFERENCES users (userId)
);