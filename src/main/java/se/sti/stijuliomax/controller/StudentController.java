package se.sti.stijuliomax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.sti.stijuliomax.entity.Student;
import se.sti.stijuliomax.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudent() {
        return studentService.getStudent();
    }

    @GetMapping(path = "{personalId}")
    public Optional<Student> findById(@PathVariable("personalId") Long personalId) {
        return studentService.findById(personalId);
    }

    @PutMapping(path = "{personalId}/addCourse/{courseId}")
    public Student addCourse(@PathVariable("personalId") Long personalId, @PathVariable("courseId") Long courseId) {
        return studentService.addCourse(personalId, courseId);
    }

    @PutMapping(path = "{personalId}/removeCourse/{courseId}")
    public Student removeCourse(@PathVariable("personalId") Long personalId, @PathVariable("courseId") Long courseId) {
        return studentService.removeCourse(personalId, courseId);
    }

    @PostMapping
    public Student addNewStudent(@RequestBody Student student) {
       return studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{personalId}")
    public void deleteStudent(@PathVariable("personalId") Long personalId) {
        studentService.deleteStudent(personalId);
    }
}
