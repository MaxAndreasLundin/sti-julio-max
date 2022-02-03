package se.sti.stijuliomax.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.sti.stijuliomax.entity.Course;
import se.sti.stijuliomax.service.CourseService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/course")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getCourse() {
        return courseService.getCourse();
    }

    @PostMapping
    public void registerNewCourse(@RequestBody Course course) {
        log.info("Adding new course");
        courseService.addNewCourse(course);
    }

    @DeleteMapping(path = "{courseId}")
    public void deleteCourse(@PathVariable("courseId") Long courseId) {
        log.info("Deleting course with id: {}", courseId);
        courseService.deleteCourse(courseId);
    }
}
