drop type if exists user_role;
create type user_role as enum('USER', 'ADMINISTRATOR');

drop table if exists users cascade ;
create table users(
                      id serial primary key,
                      username varchar(255),
                      password varchar(255),
                      first_name varchar(255),
                      last_name varchar(255),
                      user_role user_role
);

insert into users(username, password, first_name, last_name, user_role)
values ('bida@gmail.com', '1234567890', 'Nazarii', 'Bida', 'ADMINISTRATOR');

insert into users(username, password, first_name, last_name, user_role)
values ('bida2@gmail.com', '1234567890', 'Nazarii', 'Bida', 'USER');

drop table if exists models cascade;
create table models(
                       id serial primary key,
                       name varchar(255),
                       value int,
                       mark_id int
);