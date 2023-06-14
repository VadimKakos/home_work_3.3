--liquibase formatted sql

--changeset vkosolapov:1
CREATE INDEX name ON student (name);
CREATE index nameFaculty_colorFaculty on faculty (name, color);

