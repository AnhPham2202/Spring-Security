package na.pham.spring.security.demo.controller;

import na.pham.spring.security.demo.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class StudentController {
    private static final List<Student> listStudents = Arrays.asList(
            new Student(1, "na 1"),
            new Student(2, "na 2"),
            new Student(3, "na 3")
    );

    @GetMapping("/student/{id}")
    public List<Student> getStudent(@PathVariable Integer id) {
        return listStudents
                .stream()
                .filter(s -> id.equals(s.getId()))
                .collect(Collectors.toList());
    }

    @PostMapping("/student")
    public String createStudent(@RequestBody Student student) {
        return "ok";
    }

    @PutMapping("/student/{id}")
    public List<Student> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        return listStudents
                .stream()
                .filter(s -> id.equals(s.getId()))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/student/{id}")
    public List<Student> deleteStudent(@PathVariable Integer id) {
        return listStudents
                .stream()
                .filter(s -> id.equals(s.getId()))
                .collect(Collectors.toList());
    }
}
