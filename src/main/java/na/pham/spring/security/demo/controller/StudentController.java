package na.pham.spring.security.demo.controller;

import na.pham.spring.security.demo.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
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
}
