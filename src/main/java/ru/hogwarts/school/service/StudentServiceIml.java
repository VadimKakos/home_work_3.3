package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositoryes.StudentRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceIml implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceIml(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private final Logger logger = LoggerFactory.getLogger(StudentServiceIml.class);

    //create
    public Student createStudent(Student student) {
        logger.debug("Was invoked method for create student");
        if (findStudent(student.getId()).isEmpty()) {
            return studentRepository.save(student);
        }
        return null;
    }


    //find
    public Optional<Student> findStudent(long id) {
        logger.debug("Was invoked method for find student with id:{}", id);
        return studentRepository.findById(id);
    }

    //edit
    public Student editStudent(Student student) {
        logger.debug("Was invoked method for edit student");
        if (findStudent(student.getId()).isEmpty()) {
            logger.warn("student not found");
            return null;
        }
        return studentRepository.save(student);
    }

    //delete
    public void deleteStudent(long id) {
        logger.debug("Was invoked method for delete student by id:{}", id);
        studentRepository.deleteById(id);
    }

    //getAll
    public Collection<Student> getStudent() {
        logger.debug("Was invoked method for get all student");
        return studentRepository.findAll();
    }

    //findByBetween
    @Override
    public Collection<Student> findStudentsInBetween(int from, int to) {
        logger.debug("Was invoked method for find student in between from{} to {}", from, to);
        return studentRepository.findByAgeBetween(from, to);
    }

    //findFacultyOfStudent
    @Override
    public Faculty findFacultyOfStudent(long id) {
        logger.debug("Was invoked method for find faculty of student with id{}", id);
        return studentRepository.findStudentById(id).getFaculty();
    }

    //findByAge
    public Collection<Student> getStudentByAge(int age) {
        logger.debug("Was invoked method for find student by age{}", age);
        return studentRepository.findByAge(age);
    }

    public Integer getAmountStudentInSchool() {
        logger.debug("Was invoked method for get amount student in school");
        return studentRepository.getAmountStudentInSchool();
    }

    public Double getAverageAgeStudents() {
        logger.debug("Was invoked method for get average age student");
        return studentRepository.getAverageAgeStudents();
    }

    public List<Student> getLastFiveStudents() {
        logger.debug("Was invoked method for get last five student");
        return studentRepository.getLastFiveStudents();
    }

    @Override
    public List<String> findStudentBeginWithLetterA() {
        return studentRepository.
                findAll().stream().map(e -> e.getName().toUpperCase()).
                filter(e -> e.charAt(0) == "А".charAt(0)).toList();
    }

    @Override
    public double getAverageAge() {
        return studentRepository.
                findAll().stream().mapToInt(Student::getAge).average().orElseThrow();
    }

    @Override
    public void getThreadStudents() {
        List<String> students = getStudent().stream().map(Student::getName).toList();

        System.out.println(students.get(0));
        System.out.println(students.get(1));

        new Thread(() -> {
            System.out.println(students.get(2));
            System.out.println(students.get(3));
        }).start();
        new Thread(() -> {
            System.out.println(students.get(4));
            System.out.println(students.get(5));
        }).start();
    }

    @Override
    public void getThreadStudents2() {
        List<String> students = getStudent().stream().map(Student::getName).limit(6).toList();
        getName(students.get(0));
        getName(students.get(1));
        new Thread(() -> {
            getName(students.get(2));
            getName(students.get(3));
        }).start();
        new Thread(() -> {
            getName(students.get(4));
            getName(students.get(5));
        }).start();

    }

    private void getName(String name) {
        synchronized (name) {
            System.out.println(Thread.currentThread().getName() + " " + name);
        }
    }
}


