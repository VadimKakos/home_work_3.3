package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositoryes.StudentRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class StudentServiceIml implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceIml(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    //create
    public Student createStudent(Student student) {
        if (findStudent(student.getId()).isEmpty()) {
            return studentRepository.save(student);
        }
        return null;
    }

    //find
    public Optional<Student> findStudent(long id) {
        return studentRepository.findById(id);
    }

    //edit
    public Student editStudent(Student student) {
        if (findStudent(student.getId()).isEmpty()) {
            return null;
        }
        return studentRepository.save(student);
    }

    //delete
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }
    //getAll
    public Collection<Student> getStudent() {
        return studentRepository.findAll();
    }

    //findByBetween
    @Override
    public Collection<Student> findStudentsInBetween(int from, int to) {
        return studentRepository.findByAgeBetween(from, to);
    }

    //findFacultyOfStudent
    @Override
    public Faculty findFacultyOfStudent(long id) {
        Student student = new Student();
        student = studentRepository.findStudentById(id);
        return student.getFaculty();
    }

    //findByAge
    public Collection<Student> getStudentByAge(int age) {
        return studentRepository.findByAge(age);
    }


}


