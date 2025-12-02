insert into class values
(1,'A1','2008/12/20',b'1'),
(2,'A2','2008/12/22',b'1'),
(3,'B3',current_date(),b'0');

insert into student(student_name,address,phone,student_status,classID) values
('Hung','Ha Noi', '0912113113',b'1',1),
('Hoa','Hai Phong', '0912113113',b'1',1),
('Manh','HCM', '0912113113',b'1',1);

insert into subjects (subName,creadit,sub_status) values
('CF',5,b'1'),
('C',6,b'1'),
('HDJ',5,b'1'),
('RDBMS',10,b'1');

insert into mark values
(1,1,1,8,1),
(2,1,2,10,2),
(3,2,1,12,1);