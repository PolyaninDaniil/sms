--liquibase formatted sql

--changeset daniil.polyanin:SMS-1

create table employee
(
    id          bigint auto_increment
        primary key,
    age         int null,
    first_name  varchar(255) null,
    second_name varchar(255) null
);
create table project
(
    id       bigint auto_increment
        primary key,
    end_date datetime(6) null,
    name     varchar(255) null,
    type     int null
);
create table employee_projects
(
    employees_id bigint not null,
    projects_id  bigint not null,
    constraint FK88mdj5vmp7md19u4cbq154dk6
        foreign key (employees_id) references employee (id),
    constraint FKg10a7uho2lylw8g080l5j4gyk
        foreign key (projects_id) references project (id)
);

--rollback DROP TABLE employee_projects;
--rollback DROP TABLE project;
--rollback DROP TABLE employee;