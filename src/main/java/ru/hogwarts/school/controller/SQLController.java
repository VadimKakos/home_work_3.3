package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.List;

@RestController
public class SQLController {

    private final StudentService studentService;

    public SQLController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("countStudents")
    public Integer getAmountStudentInSchool() {
        return studentService.getAmountStudentInSchool();
    }

    @GetMapping("averageAgeStudents")
    public Double getAverageAgeStudents() {
        return studentService.getAverageAgeStudents();
    }
    @GetMapping("lastFiveStudents")
    public List<Student> getLastFiveStudents() {
        return studentService.getLastFiveStudents();
    }
}
