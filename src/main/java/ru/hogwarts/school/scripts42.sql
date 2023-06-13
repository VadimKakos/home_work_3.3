ALTER TABLE student
    ADD CONSTRAINT age_constraint CHECK ( age > 16 );

ALTER TABLE student
    ADD CONSTRAINT name_unique UNIQUE (name),
ALTER COLUMN name SET NOT NULL;

ALTER TABLE faculty
    ADD CONSTRAINT color_name_unique UNIQUE (color, name);

ALTER TABLE student
    ADD CONSTRAINT age_default DEFAULT (20) FOR (age);
