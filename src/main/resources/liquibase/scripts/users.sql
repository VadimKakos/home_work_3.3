--liquibase formatted sql

--changeset vkosolapov:1
CREATE TABLE users(
    id SERIAL,
    email TEXT
);
