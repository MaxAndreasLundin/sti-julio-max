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

    @GetMapping(path = "{studentId}")
    public Optional<Student> findById(@PathVariable("studentId") Long studentId) {
        return studentService.findById(studentId);
    }

    @PutMapping(path = "{studentId}/addCourse/{courseId}")
    public Student addCourse(@PathVariable("studentId") Long studentId, @PathVariable("courseId") Long courseId) {
        return studentService.addCourse(studentId, courseId);
    }

    @PutMapping(path = "{studentId}/removeCourse/{courseId}")
    public Student removeCourse(@PathVariable("studentId") Long studentId, @PathVariable("courseId") Long courseId) {
        return studentService.removeCourse(studentId, courseId);
    }

    @PostMapping
    public void addNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }
}
