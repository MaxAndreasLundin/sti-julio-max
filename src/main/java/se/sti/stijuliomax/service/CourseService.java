package se.sti.stijuliomax.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.sti.stijuliomax.entity.Course;
import se.sti.stijuliomax.repository.CourseRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public List<Course> getCourse() {
        return courseRepository.findAll();
    }

    public void addNewCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(Long courseId) {
        boolean exists = courseRepository.existsById(courseId);
        if (!exists) {
            throw new IllegalStateException("course with id " + courseId + " does not exists");
        }
        courseRepository.deleteById(courseId);
    }
}
