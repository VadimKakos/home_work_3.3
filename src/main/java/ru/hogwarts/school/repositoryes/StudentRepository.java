package ru.hogwarts.school.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByAge(int age);

    Student findStudentById(Long id);
    Collection<Student> findByAgeBetween(int age, int age2);

    @Query(value = "SELECT COUNT(name) FROM student" ,nativeQuery = true)
    Integer getAmountStudentInSchool();
    @Query(value = "SELECT AVG(age) FROM student" ,nativeQuery = true)
    Double getAverageAgeStudents();
    @Query(value = "select * from student order by id desc Limit 5",nativeQuery = true)
    List<Student> getLastFiveStudents();
}
