CREATE TABLE Book (
    id int primary key not null,
    title varchar(100) not null,
    author_id int not null
);

CREATE TABLE Author  (
    id int primary key not null,
    name varchar(100) not null
);

create sequence book_sequence start with 1 increment by 1;
create sequence author_sequence start with 1 increment by 1;

ALTER TABLE Book ADD FOREIGN KEY (author_id) REFERENCES Author(id);

INSERT INTO Author(id, name) VALUES (1, 'Victor Hugo');
INSERT INTO Author(id, name) VALUES (2, 'Hemmingway');
