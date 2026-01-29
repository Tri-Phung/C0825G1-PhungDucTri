select * from student;

select * from student where student_status = true;

select * from subjects where creadit<10;

select s.student_name, c.class_name
from student s
join class c on s.classID = c.classID
where class_name like 'A1';

select s.student_name, sub.subName, m.mark
from student s
join mark m on s.studentID = m.studentID
join subjects sub on m.subID = sub.subID
where subName = 'CF';