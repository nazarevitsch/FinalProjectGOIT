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

drop table if exists regions cascade;
create table regions(
                        id serial primary key,
                        name varchar(255),
                        value int
);

drop table if exists colors cascade;
create table colors(
                       id serial primary key,
                       name varchar(255),
                       value int
);

drop table if exists searches cascade;
create table searches(
                         id serial primary key,
                         username varchar(255),
                         category_id int,
                         body_style_id int,
                         mark_id int,
                         model_id int,
                         gear_box_id int,
                         fuel_type_id int,
                         region_id int,
                         color_id int,
                         price_from int,
                         price_to int
);