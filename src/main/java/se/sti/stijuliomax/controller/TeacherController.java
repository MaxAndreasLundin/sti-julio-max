package se.sti.stijuliomax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.sti.stijuliomax.entity.Teacher;
import se.sti.stijuliomax.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getTeacher() {
        return teacherService.getTeacher();
    }

    @PostMapping
    public void registerNewTeacher(@RequestBody Teacher teacher) {
        teacherService.addNewTeacher(teacher);
    }

    @DeleteMapping(path = "{teacherId}")
    public void deleteTeacher(@PathVariable("teacherId") Long teacherId) {
        teacherService.deleteTeacher(teacherId);
    }
}