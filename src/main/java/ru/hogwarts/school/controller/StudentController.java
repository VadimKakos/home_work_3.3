package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {
     private final StudentService studentService;

     public StudentController(StudentService studentService) {
         this.studentService = studentService;
     }

     @GetMapping("{id}")
     public ResponseEntity<Student> findStudent(@PathVariable long id) {
         Student student = studentService.findStudent(id);
         if (student == null) {
             return ResponseEntity.notFound().build();
         }
         return ResponseEntity.ok(student);
     }

     @GetMapping
     public ResponseEntity<Collection<Student>> getStudent() {
         return ResponseEntity.ok(studentService.getStudent());
     }
     @GetMapping("/age{age}")
     public Collection<Student> getStudentByAge(@PathVariable int age) {
         return studentService.getStudentByAge(age);
     }

     @PostMapping
     public Student createStudent(@RequestBody Student student) {
         return studentService.createStudent(student);
     }

     @PutMapping
     public ResponseEntity<Student> editStudent(@RequestBody Student student) {
         Student editsStudent = studentService.editStudent(student);
         if (editsStudent == null) {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
         }
         return ResponseEntity.ok(student);
     }

     @DeleteMapping("{id}")
     public ResponseEntity<Student> deleteStudent(@PathVariable long id) {
         studentService.deleteStudent(id);
         return ResponseEntity.ok().build();
     }
}
