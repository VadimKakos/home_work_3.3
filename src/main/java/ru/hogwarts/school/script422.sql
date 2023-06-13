CREATE TABLE man
(
    id INTEGER NOT NULL PRIMARY KEY,
    name    TEXT not null ,
    age     INTEGER default 1,
    license BOOLEAN default 0,
    car     INTEGER[] REFERENCES car (id)
);
CREATE TABLE car
(
    id INTEGER NOT NULL PRIMARY KEY,
    brand  TEXT not null ,
    model  TEXT default "gran",
    salary INTEGER not null,
    driver integer references  man (id)
);