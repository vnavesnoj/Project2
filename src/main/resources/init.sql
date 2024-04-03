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
    books_id  INT REFERENCES books (id),
    PRIMARY KEY (people_id, books_id)
);
