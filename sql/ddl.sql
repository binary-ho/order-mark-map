drop table if exists DELIVERY CASCADE;
create table DELIVERY
(
    id bigint generated by default as identity,
    userName varchar(30),
    menu varchar(255),
    address varchar(255),
    locationX varchar(255),
    locationY varchar(255),
    primary key (id)
);