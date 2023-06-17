package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    //find
    @GetMapping("{id}")
    public ResponseEntity<Optional<Student>> findStudent(@PathVariable long id) {
        Optional<Student> student = studentService.findStudent(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.notFound().build();
    }


    //get
    @GetMapping
    public ResponseEntity<Collection<Student>> getStudent() {
        return ResponseEntity.ok(studentService.getStudent());
    }

    //getByAge
    @GetMapping("/age")
    public Collection<Student> getStudentByAge(@RequestParam int age) {
        return studentService.getStudentByAge(age);
    }


    //create
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createStudent = studentService.createStudent(student);
        if (createStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(createStudent);
    }

    //edit
    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        Student editsStudent = studentService.editStudent(student);
        if (editsStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    //delete
    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    //findBetween
    @GetMapping("between")
    public Collection<Student> findStudentsInBetween(@RequestParam int from, @RequestParam int to) {
        return studentService.findStudentsInBetween(from, to);
    }

    //studentsFaculty
    @GetMapping("/{id}/faculty")
    public Faculty findStudentsFaculty(@PathVariable long id) {
        return studentService.findFacultyOfStudent(id);
    }

    //A students
    @GetMapping("/withLetterA")
    public List<String> findStudentBeginWithLetterA() {
        return studentService.findStudentBeginWithLetterA();
    }

    //averageAge streams
    @GetMapping("/averageAge")
    public Double getAverageAge() {
        return studentService.getAverageAge();
    }

    //Thread
    @GetMapping("/threadStudents")
    public void getThreadStudents() {
        studentService.getThreadStudents();
    }
}
