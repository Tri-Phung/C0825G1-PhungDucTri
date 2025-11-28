create database student_management;

use student_management;

create table student (
	id int not null,
    student_name varchar(100),
    age int check (age > 0) not null,
    country varchar(200),
    primary key(id)
);

create table class (
	id int not null,
    class_name varchar(100) not null,
    primary key(id)
);

create table teacher (
	id int not null,
    teacher_name varchar(100) not null,
    age int check (age > 0) not null,
    country varchar(200) not null,
    primary key(id)
);