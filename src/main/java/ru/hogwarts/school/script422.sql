CREATE TABLE man
(
    name    TEXT not null PRIMARY KEY,
    age     INTEGER default 1,
    license BOOLEAN default false,
    car     INTEGER REFERENCES car (id)
);
CREATE TABLE car
(
    id INTEGER NOT NULL PRIMARY KEY,
    brand  TEXT not null ,
    model  TEXT not null ,
    salary INTEGER not null
);