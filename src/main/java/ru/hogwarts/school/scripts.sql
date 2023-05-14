select name
from student
where age > 20
  and age < 30;

select name
from student;

select name
from student
where name like '%d%';

select name
from student
where age<student.id;

select name
from student
order by age