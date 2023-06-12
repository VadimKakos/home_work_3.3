package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.service.StudentService;

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
    public Integer getAverageAgeStudents() {
        return studentService.getAverageAgeStudents();
    }
}
