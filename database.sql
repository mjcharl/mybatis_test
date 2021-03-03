CREATE TABLE student (
    id         serial PRIMARY KEY,
    name       varchar(30),
    branch     varchar(30),
    percentage integer,
    email      varchar(30),
    phone      integer
);