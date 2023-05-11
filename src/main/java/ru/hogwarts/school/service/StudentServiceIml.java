package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositoryes.StudentRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class StudentServiceIml implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceIml(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    //create
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    //find
    public Student findStudent(long id) {
        return studentRepository.findById(id).get();
    }

    //edit
    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }



    //delete
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }
    public Collection<Student> getStudent() {
        return studentRepository.findAll();
    }
    //findByAge
    public Collection<Student> getStudentByAge(int age) {
        return studentRepository.findAll().stream()
                .filter(student -> student
                        .getAge() == age)
                .collect(Collectors.toList());
    }
}


