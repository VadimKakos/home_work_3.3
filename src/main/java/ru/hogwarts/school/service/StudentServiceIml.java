package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
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
        if (findStudent(student.getId()).isPresent()) {
            return null;
        }
        return studentRepository.save(student);
    }

    //find
    public Optional<Student> findStudent(long id) {
        if (studentRepository.findById(id).isPresent()) {
            return Optional.of(studentRepository.findById(id).get());
        }
        return Optional.empty();
    }

    //edit
    public Student editStudent(Student student) {
        if (findStudent(student.getId()).isPresent()) {
            return studentRepository.save(student);
        }
        return null;
    }

    //delete
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }
    public Collection<Student> getStudent() {
        return studentRepository.findAll();
    }

    public Collection<Student> getStudentByAge(int age) {
        return studentRepository.findByAge(age);
    }
}


