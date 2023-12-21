drop database if exists information;

create database information;

use information;

create table classroom
(
    id   int         not null primary key auto_increment,
    name varchar(60) not null
);

create table student
(
    id          int          not null primary key auto_increment,
    name        varchar(60)  not null,
    dob         varchar(60)  not null,
    address     varchar(100) not null,
    phoneNumber varchar(60)  not null,
    email       varchar(60)  not null,
    idClassRoom int,
    foreign key (idClassRoom) references classroom (id)
);

insert into classroom(name) values ('C06');
insert into classroom(name) values ('C07');
insert into classroom(name) values ('C08');
insert into classroom(name) values ('C09');
insert into classroom(name) values ('C10');