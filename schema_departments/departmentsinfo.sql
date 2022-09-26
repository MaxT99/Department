create table schema_departments.departmentsinfo
(
    id          int auto_increment
        primary key,
    name        varchar(30)  not null,
    phone       varchar(20)  not null,
    email       varchar(20)  not null,
    address     varchar(50)  not null,
    description varchar(200) not null
);

