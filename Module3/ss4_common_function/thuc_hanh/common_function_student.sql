use quanlysinhvien;

select address, count(student_id) as `student number`
from students
group by address;

select s.student_id, s.student_name, avg(mark) as `average`
from students s
join marks m on s.student_id = m.student_id
group by student_id;

select s.student_id, s.student_name, avg(mark) as `average`
from students s
join marks m on s.student_id = m.student_id
group by student_id
having avg(mark) > 15;

select s.student_id, s.student_name, avg(mark) as `average`
from students s
join marks m on s.student_id = m.student_id
group by student_id
having avg(mark) >= all(select avg(mark) from marks group by marks.student_id);