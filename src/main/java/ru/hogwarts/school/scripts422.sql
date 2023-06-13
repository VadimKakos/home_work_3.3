select student.name, student.age, faculty.name
from student
         INNER JOIN faculty on student.faculty_id = faculty.id;
select student.name
from student
         INNER JOIN avatar on student.id = avatar.student_id;