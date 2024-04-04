CREATE TABLE people
(
    id            SERIAL PRIMARY KEY,
    full_name     VARCHAR UNIQUE,
    year_of_birth INT
);

CREATE TABLE books
(
    id     SERIAL PRIMARY KEY,
    author VARCHAR,
    name   VARCHAR,
    year   INT
);
CREATE TABLE library
(
    people_id INT REFERENCES people (id),
    books_id  INT PRIMARY KEY REFERENCES books (id)
);
ALTER SEQUENCE books_id_seq RESTART WITH 2;