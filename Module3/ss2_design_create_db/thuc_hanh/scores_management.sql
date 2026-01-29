create database QuanLyDiemThi;

use QuanLyDiemThi;

create table hoc_sinh(
MaHS varchar(20),
TenHS varchar(50),
NgaySinh datetime,
Lop varchar(20),
GT varchar(20),
primary key(MaHS)
);

create table giao_vien (
	MaGV varchar(20),
    TenGV varchar(50),
    SDT varchar(10),
    primary key (MaGV)
);

create table mon_hoc (
	MaMH varchar(20),
    TenMH varchar(50),
    MaGV varchar(20),
    primary key(MaMH)
);

create table bang_diem (
	MaHS varchar(20),
    MaMH varchar(50),
    DiemThi int,
    NgayKT datetime
);

alter table mon_hoc
add constraint fk_MaGV foreign key (MaGV) references giao_vien(MaGV);

alter table bang_diem
add primary key (MaHS,MaMH),
add constraint fk_MaHS foreign key (MaHS) references hoc_sinh(MaHS),
add constraint fk_MaMH foreign key (MaMH) references mon_hoc(MaMH);