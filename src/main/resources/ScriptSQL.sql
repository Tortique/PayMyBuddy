CREATE DATABASE prod;
USE PROD;

CREATE TABLE user
(
    userId   INTEGER             NOT NULL PRIMARY KEY AUTO_INCREMENT,
    email    VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100)        NOT NULL,
    name     VARCHAR(30)         NOT NULL,
    enabled  TINYINT(4) DEFAULT NULL
);

CREATE TABLE friend
(
    userId   INTEGER NOT NULL,
    friendId INTEGER NOT NULL,
    PRIMARY KEY (userId, friendId),
    FOREIGN KEY (userId)
        REFERENCES user (userId),
    FOREIGN KEY (friendId)
        REFERENCES user (userId)
);

CREATE TABLE account
(
    accountId INTEGER NOT NULL PRIMARY KEY,
    balance   DECIMAL(6, 2) CHECK ( balance >=0 )
);

CREATE TABLE transaction
(
    transactionId INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    transactionUserId   INTEGER       NOT NULL,
    transactionFriendId INTEGER       NOT NULL,
    value               DECIMAL(6, 2) NOT NULL,
    comment             VARCHAR(20)
);