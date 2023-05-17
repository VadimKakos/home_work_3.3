package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.Optional;

public interface StudentService {

    Student createStudent(Student student);

    Optional<Student> findStudent(long id);

    void deleteStudent(long id);

    Student editStudent(Student student);

    Collection<Student> getStudentByAge(int age);

    Collection<Student> getStudent();

    Collection<Student> findStudentsInBetween(int from, int to);

    Faculty findFacultyOfStudent(long id);
}
