package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface StudentService {

    Student createStudent(Student student);

    Student findStudent(long id);

    void deleteStudent(long id);

    Student editStudent(Student student);

    Collection<Student> getStudentByAge(int age);

    Collection<Student> getStudent();
}
