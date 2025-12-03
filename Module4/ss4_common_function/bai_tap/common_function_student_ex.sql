use quanlysinhvien;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select sub_id, sub_name, creadit, sub_status
from subjects
where creadit >= (select max(creadit) from subjects);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.

select s.sub_id, s.sub_name, s.creadit, s.sub_status, m.mark
from subjects s
join marks m on s.sub_id = m.sub_id
where m.mark >= (select max(mark) from marks);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần

select s.student_id, s.student_name, s.address, s.phone, s.student_status, avg(m.mark) as average
from students s
join marks m on s.student_id = m.student_id
group by s.student_id
order by average desc;