create database QuanLySinhVien;

use QuanLySinhVien;

create table class (
	classID int auto_increment,
    class_name varchar(60) not null,
    start_date datetime not null,
    class_status bit,
    primary key(classID)
);

create table student (
	studentID int auto_increment,
    student_name varchar(30) not null,
    address varchar(50),
    phone varchar(20),
    student_status bit,
    classID int not null,
    primary key(studentID)
);

create table subjects (
	subID int auto_increment,
    subName varchar(30) not null,
    creadit tinyint not null default 1 check(creadit >= 1),
    sub_status bit default 1,
    primary key(subID)
);

create table mark (
	markID int auto_increment,
    subID int not null unique,
    studentID int not null unique,
    mark float default 0 check (mark between 0 and 100),
    exam_times tinyint default 1,
    primary key (markID)
);

alter table student
add constraint fk_classID foreign key (classID) references class(classID);
alter table mark
add constraint fk_subID foreign key (subID) references subjects(subID),
add constraint fk_studentID foreign key (studentID) references student(studentID);