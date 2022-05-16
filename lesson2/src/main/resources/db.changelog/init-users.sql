create table users
(
    username   varchar,
    email      varchar unique,
    first_name varchar,
    last_name  varchar,
    phone      varchar unique,
    primary key (username)
);

insert into users(username, email, first_name, last_name, phone)
values ('johny', 'j@mail.ru', 'John', 'Doe', '+3214'),
       ('spomprt', 's@mail.ru', 'Mattew', 'Bobrikov', '+4265'),
       ('smith', 'sm@mail.ru', 'Bill', 'Smith', '+9830'),
       ('top_s3cr3t', 'top@mail.ru', 'Ivan', 'Ivanov', '+3211');